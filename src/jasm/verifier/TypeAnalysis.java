// Copyright (c) 2011, David J. Pearce (djp@ecs.vuw.ac.nz)
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//    * Redistributions of source code must retain the above copyright
//      notice, this list of conditions and the following disclaimer.
//    * Redistributions in binary form must reproduce the above copyright
//      notice, this list of conditions and the following disclaimer in the
//      documentation and/or other materials provided with the distribution.
//    * Neither the name of the <organization> nor the
//      names of its contributors may be used to endorse or promote products
//      derived from this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
// ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
// WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
// DISCLAIMED. IN NO EVENT SHALL DAVID J. PEARCE BE LIABLE FOR ANY
// DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
// (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
// LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
// ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
// (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
// SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

package jasm.verifier;

import jasm.attributes.Code;
import jasm.attributes.StackMapTable;
import jasm.lang.Bytecode;
import jasm.lang.ClassFile;
import jasm.lang.JvmType;
import jasm.lang.JvmTypes;
import jasm.lang.Bytecode.ArrayLength;
import jasm.lang.Bytecode.ArrayLoad;
import jasm.lang.Bytecode.ArrayStore;
import jasm.lang.Bytecode.BinOp;
import jasm.lang.Bytecode.CheckCast;
import jasm.lang.Bytecode.Cmp;
import jasm.lang.Bytecode.Conversion;
import jasm.lang.Bytecode.Dup;
import jasm.lang.Bytecode.DupX1;
import jasm.lang.Bytecode.DupX2;
import jasm.lang.Bytecode.GetField;
import jasm.lang.Bytecode.If;
import jasm.lang.Bytecode.IfCmp;
import jasm.lang.Bytecode.Iinc;
import jasm.lang.Bytecode.InstanceOf;
import jasm.lang.Bytecode.Invoke;
import jasm.lang.Bytecode.Load;
import jasm.lang.Bytecode.LoadConst;
import jasm.lang.Bytecode.MonitorEnter;
import jasm.lang.Bytecode.MonitorExit;
import jasm.lang.Bytecode.Neg;
import jasm.lang.Bytecode.Nop;
import jasm.lang.Bytecode.Pop;
import jasm.lang.Bytecode.PutField;
import jasm.lang.Bytecode.Return;
import jasm.lang.Bytecode.Swap;
import jasm.lang.Bytecode.Throw;
import jasm.lang.ClassFile.Method;
import jasm.util.dfa.ForwardFlowAnalysis;

import java.util.List;


/**
 * <p>
 * A forward flow analysis which determines the type of each variable and stack
 * location in a given <code>ClassFile.Method</code>. In the case of a method
 * which is not well-typed, a verification error is reported. For valid methods,
 * a <code>StackMapTable</code> attribute is added to the <code>Code</code>
 * attribute (and any existing one replaced).
 * </p>
 * 
 * @author David J. Pearce
 * 
 */
public class TypeAnalysis extends ForwardFlowAnalysis<TypeAnalysis.Store>{
	private ClassFile clazz;         // currently being analysed
	private ClassFile.Method method; // currently being analysed
	
	/**
	 * Apply the analysis to every method in a classfile, creating the necessary
	 * <code>StackMapTable</code> attributes.
	 * 
	 * @param cf
	 */
	public void apply(ClassFile cf) {
		this.clazz = cf;
		for (ClassFile.Method method : cf.methods()) {
			// FIXME: this feels like a hack.
			if(method.attribute(Code.class) != null) {
				Store[] stores = apply(method);
				addStackMapTable(method,stores);
			}
		}
	}
	
	/**
	 * Apply the analysis to a given method in a classfile.
	 * 
	 * @param cf
	 */
	public Store[] apply(ClassFile.Method method) {
		this.method = method;
		return super.apply(method);
	}
	
	protected void addStackMapTable(ClassFile.Method method, Store[] stores) {
		Code attr = method.attribute(Code.class);
		if (attr == null) {
			// sanity check
			throw new IllegalArgumentException(
					"cannot apply forward flow analysis on method without code attribute");
		}
		StackMapTable existing = attr.attribute(StackMapTable.class);
		if(existing != null) {
			attr.attributes().remove(existing);
		}
		StackMapTable.Frame[] frames = new StackMapTable.Frame[stores.length];
		for (int i = 0; i != frames.length; ++i) {
			Store store = stores[i];
			if(store != null) {
				frames[i] = new StackMapTable.Frame(store.maxLocals, store.stack - store.maxLocals,
						store.types);
			} else {
				// dead code
			}
		}
		attr.attributes().add(new StackMapTable(frames));
	}
	
	@Override
	public Store[] initialise(Code attr, Method method) {	
		// First, create the initial store from the parameter types.
		List<JvmType> paramTypes = method.type().parameterTypes();
		JvmType[] types = new JvmType[attr.maxLocals() + attr.maxStack()];
		int index = 0;
 
		if(!method.isStatic()) {
			// Non-static methods have receiver at index 0
			types[index++] = clazz.type();
		}
		
		// All methods have parameters in the local variable array on entry.
		for (JvmType t : paramTypes) {
			// Normalise types because of the discrepancy between declared
			// types, and the types considered in the local variable array (i.e.
			// declared type bool is int in local varaible array).
			types[index] = normalise(t);
			
			if (t instanceof JvmType.Long || t instanceof JvmType.Double) {
				// for some reason, longs and doubles occupy two slots.
				index = index + 2;
			} else {
				index = index + 1;
			}
		}
		// set all remaining local variables to have void type
		for(int i=index;i!=attr.maxLocals();++i) {
			types[i] = JvmTypes.T_VOID;
		}
		// Now, create the stores array (one element for each bytecode);
		Store[] stores = new Store[attr.bytecodes().size()];
		stores[0] = new Store(types, attr.maxLocals());
		return stores;
	}

	@Override
	public Store transfer(int index, Bytecode.Store code, Store store) {
		Store orig = store;
		store = store.clone();
		checkMinStack(1,index,orig);
		JvmType type = store.pop();
		checkIsSubtype(normalise(code.type),type,index,orig);
		store.set(code.slot,type);
		return store; 
	}

	@Override
	public Store transfer(int index, Load code, Store store) {		
		Store orig = store;
		store = store.clone();
		checkMaxStack(1,index,orig);
		JvmType type = store.get(code.slot);		
		checkIsSubtype(normalise(code.type),type,index,orig);
		store.push(type);
		return store;
	}

	@Override
	public Store transfer(int index, LoadConst code, Store store) {
		Store orig = store;
		store = store.clone();
		checkMaxStack(1,index,orig);
		Object constant = code.constant;		
		if (constant instanceof Boolean || constant instanceof Byte
				|| constant instanceof Short || constant instanceof Character
				|| constant instanceof Integer) {
			store.push(JvmTypes.T_INT);
		} else if(constant instanceof Long) {
			store.push(JvmTypes.T_LONG);
		} else if(constant instanceof Float) {
			store.push(JvmTypes.T_FLOAT);
		} else if(constant instanceof Double) {
			store.push(JvmTypes.T_DOUBLE);
		} else if(constant instanceof String) {
			store.push(JvmTypes.JAVA_LANG_STRING);
		} else if(constant == null) {
			store.push(JvmTypes.T_NULL);
		} else if(constant instanceof JvmType.Clazz) {
			store.push(JvmTypes.JAVA_LANG_CLASS);
		} else {
			throw new RuntimeException("unknown constant encountered ("
					+ constant + "," + constant.getClass().getName() + ")");
		}
		return store;
	}

	@Override
	public Store transfer(int index, ArrayLoad code, Store store) {
		Store orig = store;
		store = store.clone();
		checkMinStack(2,index,orig);
		
		JvmType i = store.pop();
		checkIsSubtype(JvmTypes.T_INT,i,index,orig);
			
		JvmType type = store.pop();
		checkIsSubtype(code.type,type,index,orig);
		
		if (type instanceof JvmType.Array) {
			JvmType.Array arrType = (JvmType.Array) type;			
			store.push(normalise(arrType.element())); 			
		} else {
			// This is a fall back, since it is permitted to perform an array
			// load / store on the null type.
			store.push(JvmTypes.T_VOID);
		}
		return store;
	}

	@Override
	public Store transfer(int index, ArrayStore code, Store store) {		
		Store orig = store;
		store = store.clone();
		checkMinStack(3,index,orig);
		
		JvmType item = store.pop();
		checkIsSubtype(normalise(code.type.element()), item, index, orig);	

		JvmType i = store.pop();
		checkIsSubtype(JvmTypes.T_INT,i,index,orig);
			
		JvmType type = store.pop();
		checkIsSubtype(code.type,type,index,orig);		
		return store;
	}

	@Override
	public void transfer(int index, Throw code, Store store) {
		checkMinStack(1,index,store);
		JvmType type = store.top();
		checkIsSubtype(JvmTypes.JAVA_LANG_THROWABLE, type, index, store);
	}

	@Override
	public void transfer(int index, Return code, Store store) {		
		if(code.type != null) {
			checkMinStack(1,index,store);
			checkIsSubtype(normalise(code.type),store.top(),index,store);
			checkIsSubtype(normalise(method.type().returnType()),store.top(),index,store);
		}
	}

	@Override
	public Store transfer(int index, Iinc code, Store store) {
		checkIsSubtype(JvmTypes.T_INT, store.get(code.slot), index, store);
		return store;
	}

	@Override
	public Store transfer(int index, BinOp code, Store store) {
		Store orig = store;
		store = store.clone();
		checkMinStack(2,index,orig);
		JvmType rhs = store.pop();
		JvmType lhs = store.pop();
		checkIsSubtype(code.type,lhs,index,orig);
		switch(code.op) {
		case Bytecode.BinOp.SHL:
		case Bytecode.BinOp.SHR:
		case Bytecode.BinOp.USHR:
			// These bytecodes are non-symmetric, and always require an int on
			// the right-hand side.
			checkIsSubtype(JvmTypes.T_INT,rhs,index,orig);
			break;
		default:
			// These bytecodes are symmetric and always require the same type on
			// both the left- and right-hand sides.
			checkIsSubtype(code.type,rhs,index,orig);
		}
		
		store.push(code.type);
		return store;
	}

	@Override
	public Store transfer(int index, Neg code, Store store) {
		Store orig = store;
		store = store.clone();
		checkMinStack(1,index,orig);
		JvmType mhs = store.pop();
		checkIsSubtype(code.type, mhs, index, orig);
		store.push(code.type);
		return store; 
	}

	@Override
	public Store transfer(int index, Bytecode.New code, Store store) {
		Store orig = store;
		store = store.clone();
		
		if (code.type instanceof JvmType.Array) {
			int dims = Math.max(1, code.dims);
			checkMinStack(dims,index,orig);
			// In the case of an array construction, there will be one or more
			// dimensions provided for the array.
			for (int i = 0; i != dims; ++i) {
				checkIsSubtype(JvmTypes.T_INT, store.pop(), index, orig);
			}
		}
		checkMaxStack(1,index,orig);
		store.push(code.type);
		return store;
	}
	
	@Override
	public Store transfer(int index, boolean branch, If code, Store store) {
		Store orig = store;
		store = store.clone();
		checkMinStack(1, index, orig);
		JvmType mhs = store.pop();
		switch (code.cond) {
		case NONNULL:
		case NULL:
			checkIsSubtype(JvmTypes.JAVA_LANG_OBJECT, mhs, index, orig);
			break;
		default:
			checkIsSubtype(JvmTypes.T_INT, mhs, index, orig);
		}
		return store;
	}

	@Override
	public Store transfer(int index, boolean branch, IfCmp code, Store store) {		
		Store orig = store;
		store = store.clone();
		checkMinStack(2,index,orig);
		JvmType rhs = store.pop();
		JvmType lhs = store.pop();
		checkIsSubtype(normalise(code.type),lhs,index,orig);
		checkIsSubtype(normalise(code.type),rhs,index,orig);
		return store;
	}

	@Override
	public Store transfer(int index, GetField code, Store store) {
		Store orig = store;
		store = store.clone();
		if(code.mode != Bytecode.FieldMode.STATIC) { 
			checkMinStack(1,index,orig);
			JvmType owner = store.pop();
			checkIsSubtype(code.owner, owner, index, orig);
		}
		checkMaxStack(1,index,store);
		store.push(normalise(code.type));
		return store;
	}

	@Override
	public Store transfer(int index, PutField code, Store store) {
		Store orig = store;
		store = store.clone();
		
		JvmType type = store.pop();
		checkIsSubtype(normalise(code.type), type, index, orig);
		
		if (code.mode != Bytecode.FieldMode.STATIC) {
			checkMinStack(2,index,orig);
			JvmType owner = store.pop();
			checkIsSubtype(code.owner, owner, index, orig);
		} else {
			checkMinStack(1,index,orig);
		}		
		
		return store;
	}

	@Override
	public Store transfer(int index, ArrayLength code, Store store) {
		Store orig = store;
		store = store.clone();
		checkMinStack(1,index,orig);
		JvmType type = store.pop();
		if (!(type instanceof JvmType.Array || type instanceof JvmType.Null)) {
			throw new VerificationException(method, index, orig,
					"arraylength requires array type, found " + type);
		}
		store.push(JvmTypes.T_INT);
		return store;
	}

	@Override
	public Store transfer(int index, Invoke code, Store store) {
		Store orig = store;
		store = store.clone();		
		JvmType.Function ftype = code.type;
		List<JvmType> parameters = ftype.parameterTypes();
		if(code.mode != Bytecode.InvokeMode.STATIC) {
			checkMinStack(parameters.size()+1,index,orig);
		} else {
			checkMinStack(parameters.size(),index,orig);
		}
		checkMinStack(parameters.size(),index,orig);
		for (int i = parameters.size() - 1; i >= 0; --i) {
			JvmType type = store.pop();
			checkIsSubtype(normalise(parameters.get(i)), type, index, orig);
		}
		if (code.mode != Bytecode.InvokeMode.STATIC) {
			JvmType type = store.pop();
			checkIsSubtype(code.owner, type, index, orig);
		}		
		JvmType rtype = ftype.returnType();
		if(!rtype.equals(JvmTypes.T_VOID)) {
			checkMaxStack(1,index,store);
			store.push(normalise(rtype));
		} 
		return store;		
	}

	@Override
	public Store transfer(int index, CheckCast code, Store store) {
		Store orig = store;
		store = store.clone();
		checkMinStack(1,index,orig);
		JvmType type = store.pop();
		// TODO: I'm slightly unsure whether or not this is a good idea!
		checkIsSubtype(type,code.type,index,orig);
		store.push(code.type);
		return store;
	}

	@Override
	public Store transfer(int index, Conversion code, Store store) {
		Store orig = store;
		store = store.clone();
		checkMinStack(1,index,orig);
		JvmType type = store.pop();
		if(!type.equals(code.from)) {
			throw new VerificationException(method, index, orig,
					"conversion expected " + code.from + ", found " + type);
		}
		store.push(code.to);
		return store;
	}

	@Override
	public Store transfer(int index, InstanceOf code, Store store) {
		Store orig = store;
		store = store.clone();		
		checkMinStack(1,index,orig);
		JvmType type = store.pop();
		checkIsSubtype(code.type,type,index,orig);
		store.push(JvmTypes.T_INT);
		return store;
	}

	@Override
	public Store transfer(int index, Pop code, Store store) {
		Store orig = store;
		store = store.clone();
		checkMinStack(1,index,orig);
		store.pop();
		return store;
	}

	@Override
	public Store transfer(int index, Dup code, Store store) {
		Store orig = store;
		store = store.clone();
		checkMaxStack(1,index,orig);
		JvmType type = store.top();
		store.push(type);
		return store;
	}

	@Override
	public Store transfer(int index, DupX1 code, Store store) {
		Store orig = store;
		store = store.clone();
		checkMinStack(2,index,orig);
		checkMaxStack(1,index,orig);
		// Duplicate the top operand stack value and insert two values down
		JvmType type = store.pop();
		JvmType gate = store.pop();
		store.push(type);
		store.push(gate);
		store.push(type);
		return store;
	}

	@Override
	public Store transfer(int index, DupX2 code, Store store) {
		// Duplicate the top operand stack value and insert two or three values
		// down
		Store orig = store;
		store = store.clone();
		checkMinStack(3,index,orig);
		checkMaxStack(1,index,orig);
		JvmType type = store.pop();
		JvmType gate1 = store.pop();
		JvmType gate2 = store.pop();
		store.push(type);
		store.push(gate2);
		store.push(gate1);
		store.push(type);
		return store;
	}

	@Override
	public Store transfer(int index, Swap code, Store store) {
		Store orig = store;
		store = store.clone();
		checkMinStack(2,index,orig);
		JvmType first = store.pop();
		JvmType second = store.pop();
		store.push(first);
		store.push(second);
		return store;
	}
	
	@Override
	public Store transfer(int index, Cmp code, Store store) {
		Store orig = store; // saved
		store = store.clone();
		checkMinStack(2,index,orig);
		JvmType lhs = store.pop();
		JvmType rhs = store.pop();
		checkIsSubtype(code.type,lhs,index,orig);
		checkIsSubtype(code.type,rhs,index,orig);
		store.push(JvmTypes.T_INT);
		return store;
	}

	@Override
	public Store transfer(int index, Nop code, Store store) {
		// does what it says on the tin ;)
		return store;
	}

	@Override
	public Store transfer(int index, MonitorEnter code, Store store) {
		Store orig = store; // saved
		store = store.clone();
		checkMinStack(1,index,orig);
		JvmType type = store.pop();
		if (type instanceof JvmType.Primitive) {
			throw new VerificationException(method, index, orig,
					"monitorenter bytecode requires Object type");
		}
		return store;
	}

	@Override
	public Store transfer(int index, MonitorExit code, Store store) {
		Store orig = store; // saved
		store = store.clone();
		checkMinStack(1,index,orig);
		JvmType type = store.pop();
		if (type instanceof JvmType.Primitive) {
			throw new VerificationException(method, index, orig,
					"monitorexit bytecode requires Object type");
		}
		return store;
	}


	@Override
	public boolean merge(int index, Store original, Store update) {
		if (original.stack != update.stack) {
			throw new VerificationException(method, index, original,
					"incompatible stack heights");
		}		
		// first check whether any changes are needed without allocating any more memory.
		JvmType[] original_types = original.types;
		JvmType[] update_types = update.types;
		boolean changed = false;		
		for(int i=0;i!=original.stack;++i) {
			JvmType ot = original_types[i];
			JvmType ut = update_types[i];
			if(ot != null && ut != null) {
				changed |= !isSubtype(ot,ut);
				original_types[i] = join(ot,ut);
			} else {
				changed |= ot != null || ut != null;
				original_types[i] = null;
			}
		}
		
		return changed;
	}
	
	protected JvmType join(JvmType t1, JvmType t2) {
		if (t1.equals(t2)) {
			return t1;
		} else if (t1 instanceof JvmType.Array && t2 instanceof JvmType.Array) {
			JvmType.Array a1 = (JvmType.Array) t1;
			JvmType.Array a2 = (JvmType.Array) t2;
			// FIXME: can we do better here?
			if (a1.element().equals(a2.element())) {
				return a1;
			}
		} else if (t1 instanceof JvmType.Reference
				&& t2 instanceof JvmType.Reference) {
			// FIXME: could do a lot better here.
			return JvmTypes.JAVA_LANG_OBJECT;
		}

		return JvmTypes.T_VOID;
	}
	

	/**
	 * Convert types into their stack based representation.
	 * 
	 * @param type
	 * @return
	 */
	private static JvmType normalise(JvmType type) {
		if (type.equals(JvmTypes.T_BOOL) || type.equals(JvmTypes.T_CHAR)
				|| type.equals(JvmTypes.T_BYTE)
				|| type.equals(JvmTypes.T_SHORT)) {
			return JvmTypes.T_INT;
		}
		return type;
	}
	
	/**
	 * Check that there are at least min items on the stack.
	 * 
	 * @param min
	 */
	protected void checkMinStack(int min, int index, Store store) {
		int stackSize = store.stack();
		if (stackSize < min) {
			throw new VerificationException(method, index, store,
					"bytecode requires " + min + " stack items, found only "
							+ stackSize + " items.");
		}
	}
	
	/**
	 * Check that there are at least max free spaces on the stack.
	 * 
	 * @param min
	 */
	protected void checkMaxStack(int max, int index, Store store) {
		int spaces = store.maxStack() - store.stack();
		if (max > spaces) {
			throw new VerificationException(method, index, store,
					"bytecode requires space for " + max + " stack items, found only "
							+ spaces + " spaces.");
		}
	}
	
	/**
	 * Check t1 is a supertype of t2 (i.e. t1 :> t2). If not, throw a
	 * VerificationException.
	 */
	protected void checkIsSubtype(JvmType t1, JvmType t2, int index, Store store) {
		if(isSubtype(t1,t2)) {
			return;
		} else {	
			Code code = method.attribute(Code.class);
			List<Bytecode> bytecodes = code.bytecodes();
			// return
			throw new VerificationException(method, index, store,
					"expected type " + t1 + ", found type " + t2 + " (index "
							+ index + ", " + bytecodes.get(index) + ")");
		}
	}	
	
	/**
	 * Determine whether t1 is a supertype of t2 (i.e. t1 :> t2). 
	 */
	protected boolean isSubtype(JvmType t1, JvmType t2) {
		if(t1.equals(t2)) {
			return true;
		} else if(t1 instanceof JvmType.Array && t2 instanceof JvmType.Array) {
			JvmType.Array a1 = (JvmType.Array) t1;
			JvmType.Array a2 = (JvmType.Array) t2;
			// NOTE: the following is technically unsound. But, it matches how
			// the JVM actually handles subtyping of arrays.
			return isSubtype(a1.element(),a2.element());
		} else if (t1.equals(JvmTypes.JAVA_LANG_OBJECT)
				&& t2 instanceof JvmType.Array) {
			return true;
		} else if (t1 instanceof JvmType.Reference
				&& t2 instanceof JvmType.Null) {
			return true;
		} else if(t1 instanceof JvmType.Clazz && t2 instanceof JvmType.Clazz) {
			// FIXME: could do a lot better here.
			return true;
		}
		return false;
	}
	
	/**
	 * Indicates that the bytecode being analysis is malformed in some manner.
	 * 
	 * @author David J. Pearce
	 * 
	 */
	public static class VerificationException extends RuntimeException {
		
		/**
		 * Classfile method which is malformed.
		 */
		private ClassFile.Method method;
		
		/**
		 * Bytecode index where the problem originated
		 */
		private int index; 
		
		/**
		 * Current state of the abstract store when the problem originated.
		 */
		private Store store;
		
		public VerificationException(ClassFile.Method method, int index, Store store, String msg) {
			super(msg);
			this.method = method;
			this.index = index;
			this.store = store;
		}
	}
	
	/**
	 * An abstract representation of the typing environment used in the JVM
	 * bytecode verifier.
	 * 
	 * @author David J. Pearce
	 * 
	 */
	protected static class Store {
		private JvmType[] types;
		private int stack; // stack pointer
		private int maxLocals;
		
		public Store(JvmType[] types, int maxLocals) {
			this.types = types;
			this.stack = maxLocals;
			this.maxLocals = maxLocals;
		}
		
		private Store(Store store) {
			this.types = store.types.clone();
			this.stack = store.stack;
			this.maxLocals = store.maxLocals;
		}
		
		public Store clone() {
			return new Store(this);
		}
		
		public int stack() {
			return stack - maxLocals;
		}
		
		public int maxLocals() {
			return maxLocals;
		}
		
		public int maxStack() {
			return types.length - maxLocals;
		}
		
		public JvmType get(int index) {
			return types[index];
		}
		
		public void set(int slot, JvmType type) {			
			types[slot] = type;
		}
		
		public JvmType top() {
			return types[stack-1];
		}
		
		public void push(JvmType type) {			
			types[stack++] = type;
		}
		
		public JvmType pop() {			
			stack = stack-1;
			return types[stack];
		}
		
		public String toString() {
			String r = "[";
			
			for(int i=0;i!=stack;++i) {
				if(i == maxLocals) {
					r = r + " | ";
				} else if(i != 0) {
					r = r + ", ";
				}
				r = r + types[i];
			}
			
			return r + "]";
		}
	}
}
