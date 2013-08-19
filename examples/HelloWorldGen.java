import java.io.*;
import java.util.*;

import jasm.lang.*;
import jasm.lang.Bytecode.Invoke;
import jasm.io.*;
import jasm.attributes.Code;

// When executed, this example generates a class file,
// HelloWorld.class, which prints "Hello World" upon execution.
public class HelloWorldGen {
	
	// Some handy constants
	public static JvmType.Clazz JAVA_LANG_SYSTEM = new JvmType.Clazz("java.lang", "System");
	public static JvmType.Clazz JAVA_IO_PRINTSTREAM = new JvmType.Clazz("java.io", "PrintStream");
	
	public static void main(String[] args) {
		ArrayList<Modifier> modifiers = new ArrayList<Modifier>();
		modifiers.add(Modifier.ACC_PUBLIC);

		// ================================================================================
		// Create an empty class file
		// ================================================================================
		ClassFile cf = new ClassFile(
				49,                                 // Java 1.5 or later
				new JvmType.Clazz("","HelloWorld"), // class is HelloWorld
				JvmTypes.JAVA_LANG_OBJECT,          // superclass is Object
				Collections.EMPTY_LIST,             // implements no interfaces
				modifiers);                         // which is public


		// ================================================================================
		// Create a static void main(String[]) method
		// ================================================================================
		modifiers = new ArrayList<Modifier>(modifiers); 
		modifiers.add(Modifier.ACC_STATIC);
		ClassFile.Method method = new ClassFile.Method(
				"main",                                              // main method
				new JvmType.Function(                                // is function
						JvmTypes.T_VOID,                             // from void
						new JvmType.Array(JvmTypes.JAVA_LANG_STRING) // to array of String
						),
						modifiers                                     // which is static public
				);

		cf.methods().add(method);

		// ================================================================================
		// Add bytecodes for printing hello world to method
		// ================================================================================
		ArrayList<Bytecode> bytecodes = new ArrayList<Bytecode>();
		
		bytecodes.add(new Bytecode.GetField(JAVA_LANG_SYSTEM, "out",
				JAVA_IO_PRINTSTREAM,
				Bytecode.FieldMode.STATIC));
		
		bytecodes.add(new Bytecode.LoadConst("Hello World"));
		
		bytecodes
		.add(new Bytecode.Invoke(JAVA_IO_PRINTSTREAM, "println",
				new JvmType.Function(JvmTypes.T_VOID,
						JvmTypes.JAVA_LANG_STRING),
						Bytecode.InvokeMode.VIRTUAL));
		
		bytecodes.add(new Bytecode.Return(null));
		
		method.attributes().add(new Code(bytecodes, Collections.EMPTY_LIST, method));

		// ================================================================================
		// Finally, write the class file to disk
		// ================================================================================
		try {
			FileOutputStream fos = new FileOutputStream("HelloWorld.class");
			ClassFileWriter cfw = new ClassFileWriter(fos);
			cfw.write(cf);
		} catch(IOException e) {
			System.out.println("I/O error --- " + e.getMessage());
		}
	}
}
