import java.io.*;
import jasm.io.*;
import jasm.lang.*;

public class ExampleReader {
    public static void main(String[] args) {	
	try {
	    FileInputStream fin = new FileInputStream(args[0]);
	    ClassFileReader reader = new ClassFileReader(fin);
	    ClassFile cf = reader.readClass();
	    System.out.println("Read class called: " + cf.name());
	} catch(IOException e) {
	    System.err.println("Error - " + e.getMessage());
	}	
    }
}
