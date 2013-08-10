import java.util.Arrays;

public class JLS_10_6_ArrayInitialisers_3 {

    public static void f(Object[] xs) {
	System.out.println("--");
	for(Object o : xs) {
	    if(o instanceof Object[]) {
		System.out.println(Arrays.toString((Object[])o));
	    } else {
		System.out.println(o);
	    }
	}	
    }

    public static void g(long[] xs) {
	System.out.println("--");
	for(long o : xs) {
	    System.out.println(o);
	}	
    }


    public static void main(String[] args) {
	f(new Object[]{new Integer(3), new Integer(2)});
	f(new Object[]{1, 2L, new Object[]{"3", "4"}});
	f(new Object[]{1, 2, new Integer(3)});
	f(new Object[]{1,2,3});
	g(new long[]{1,2L,3});
    }
}
