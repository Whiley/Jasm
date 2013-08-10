import java.lang.reflect.*;
import java.util.*;

// The purpose of this test is to look for problems compiling generic
// type signatures down into the bytecode.  Using reflection means we
// can actually "see" the bytecode, as it were.

public class JLS_8_1_2_GenericTypes_12 {

    public JLS_8_1_2_GenericTypes_12() {
	Class c = this.getClass();	
	for(Method m : c.getMethods()) {
	    if(m.getName().equals("f")) {
		System.out.println(m.getGenericReturnType());
		for(Type t : m.getGenericParameterTypes()) {
		    System.out.println(t);
		}
		for(TypeVariable p : m.getTypeParameters()) {
		    System.out.print(p + ":");
		    for(Type b : p.getBounds()) {
			System.out.println(b);
		    }
		    System.out.println(p.getGenericDeclaration());
		}
	    }
	}
	
    }

    public static <T extends Collection<String>> T f(T x) {
	return x;
    }

    public static void main(String[] args) {
	ArrayList<String> x = new ArrayList<String>(){{add("Hello");add("World");}};
	x = f(x);
	System.out.println(x);
	new JLS_8_1_2_GenericTypes_12();
    }
}