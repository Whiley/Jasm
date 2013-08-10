import java.lang.reflect.*;

// The purpose of this test is to look for problems compiling generic
// type signatures down into the bytecode.  Using reflection means we
// can actually "see" the bytecode, as it were.

public class JLS_8_1_2_GenericTypes_11 {
    public JLS_8_1_2_GenericTypes_11() {
	Class c = this.getClass();	
	for(Method m : c.getMethods()) {
	    if(m.getName().equals("f")) {
		System.out.println(m.getGenericReturnType());
		for(Type t : m.getGenericParameterTypes()) {
		    System.out.println(t);
		}
		for(TypeVariable p : m.getTypeParameters()) {
		    System.out.println(p);
		}
	    }
	}
	
    }

    public static <T extends Number> T f(T x) {
	return x;
    }

    public static void main(String[] args) {
	Integer x = 1;
	x = f(x);
	System.out.println(x);
	new JLS_8_1_2_GenericTypes_11();
    }
}