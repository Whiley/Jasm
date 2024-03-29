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

package jasm.attributes;

import jasm.io.BinaryOutputStream;
import jasm.io.ClassFileReader;
import jasm.lang.*;
import jasm.util.Triple;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class InnerClasses implements BytecodeAttribute {
	protected List<Triple<JvmType.Clazz,JvmType.Clazz,List<Modifier>>> inners;	
	protected JvmType.Clazz type;
	
	public String name() {
		return "InnerClasses";
	}
	
	/**
	 * Create an InnerClasses attribute (see JLS Section 4.7.5).
	 * 
	 * @param type
	 *            - the type of the class containing this attribute.
	 * @param inners
	 *            - the types and modifiers for all classes contained in this
	 *            class.
	 */
	public InnerClasses(JvmType.Clazz type,
			List<Triple<JvmType.Clazz, JvmType.Clazz, List<Modifier>>> inners) {
		this.type = type;
		this.inners = inners;		
	}
	
	public List<Triple<JvmType.Clazz,JvmType.Clazz,List<Modifier>>> inners() {
		return inners;
	}
	
	public JvmType.Clazz type() {
		return type;
	}
	
	@Override
	public void addPoolItems(Set<Constant.Info> constantPool) {
		Constant.addPoolItem(new Constant.Utf8("InnerClasses"), constantPool);
		for(Triple<JvmType.Clazz,JvmType.Clazz,List<Modifier>> i : inners) {			
			if(i.first() != null) {
				Constant.addPoolItem(Constant.buildClass(i.first()),constantPool);
			}
			if(i.second() != null) {
				Constant.addPoolItem(Constant.buildClass(i.second()),constantPool);
			}
			String name = i.second().lastComponent().first();
			Constant.addPoolItem(new Constant.Utf8(name),constantPool);										
		}		
	}
	
	@Override
	public void print(PrintWriter output, Map<Constant.Info, Integer> constantPool) {
		output.println("  InnerClasses:");

		for (Triple<JvmType.Clazz, JvmType.Clazz, List<Modifier>> i : inners) {
			String name = i.second().lastComponent().first();
			int nameIndex = constantPool.get(new Constant.Utf8(name));
			int outerIndex = 0;
			if (i.first() != null) {
				outerIndex = constantPool.get(Constant.buildClass(i.first()));
			}
			int innerIndex = 0;
			if (i.second() != null) {
				innerIndex = constantPool.get(Constant.buildClass(i.second()));
			}
			output.print("   ");
			output.print(nameIndex + " (");
			output.println(") = " + innerIndex + " of " + outerIndex);
		}
	}
	
	@Override
	public void write(BinaryOutputStream output, Map<Constant.Info, Integer> constantPool) throws IOException {
		output.write_u16(constantPool.get(new Constant.Utf8("InnerClasses")));
		
		int ninners = inners.size();
		
		output.write_u32(2 + (8 * ninners));
		output.write_u16(ninners);
		
		for(Triple<JvmType.Clazz,JvmType.Clazz,List<Modifier>> i : inners) {
			if(i.second() == null) {								
				output.write_u16(0);
			} else {
				output.write_u16(constantPool.get(Constant.buildClass(i.second())));
			}
			if(i.first() == null) {
				output.write_u16(0);
			} else {
				output.write_u16(constantPool.get(Constant.buildClass(i.first())));
			}
			String name = i.second().lastComponent().first();
			output.write_u16(constantPool.get(new Constant.Utf8(name)));			
			writeInnerModifiers(i.third(),output);			
		}		
	}
	
	private static void writeInnerModifiers(List<Modifier> modifiers,
			BinaryOutputStream output)
			throws IOException {
		int mods = 0;
		for (Modifier m : modifiers) {
			if (m instanceof Modifier.Public) {
				mods |= ClassFileReader.ACC_PUBLIC;
			} else if (m instanceof Modifier.Private) {
				mods |= ClassFileReader.ACC_PRIVATE;
			} else if (m instanceof Modifier.Protected) {
				mods |= ClassFileReader.ACC_PROTECTED;
			} else if (m instanceof Modifier.Static) {
				mods |= ClassFileReader.ACC_STATIC;
			} else if (m instanceof Modifier.Final) {
				mods |= ClassFileReader.ACC_FINAL;
			} else if (m instanceof Modifier.Interface) {
				mods |= ClassFileReader.ACC_INTERFACE;
			} else if (m instanceof Modifier.Abstract) {
				mods |= ClassFileReader.ACC_ABSTRACT;
			} else if (m instanceof Modifier.Synthetic) {
				mods |= ClassFileReader.ACC_SYNTHETIC;
			} else if (m instanceof Modifier.Enum) {
				mods |= ClassFileReader.ACC_ENUM;
			} 
		}

		output.write_u16(mods);
}
	
}
