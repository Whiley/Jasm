import java.util.*;
import java.io.*;
import jasm.io.*;
import jasm.lang.*;

public class ExampleWriter {
    public static void main(String[] args) {	

	List<Modifier> modifiers = new ArrayList<Modifier>();
	modifiers.add(Modifier.ACC_PUBLIC);
	
	ClassFile cf = new ClassFile(
				     49,                                 // Java 1.5 or later
				     new JvmType.Clazz("","Example"),    // class is Example
				     JvmTypes.JAVA_LANG_OBJECT,          // superclass is Object
				     Collections.EMPTY_LIST,             // implements no interfaces
				     modifiers);                         // is public
	
	try {
	    FileOutputStream fos = new FileOutputStream("Example.class");
	    ClassFileWriter cfw = new ClassFileWriter(fos);
	    cfw.write(cf);

	    System.out.println("Wrote Example.class");
	} catch(IOException e) {
	    System.err.println("Error - " + e.getMessage());
	}
    }
}
