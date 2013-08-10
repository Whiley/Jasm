import java.util.*;

public class JLS_8_1_2_GenericTypes_1 {
    public static Vector<Object> f() { return new Vector<Object>(); }
    
    public static void main (String args[]) {
	Vector vec1 = new Vector<Integer>(); // safe?
	Vector<Integer> vec2 = new Vector(); // unsafe
	Vector vec4 = new Vector<java.lang.Object>(); // safe?

	Vector vec3 = f();
    }
}
