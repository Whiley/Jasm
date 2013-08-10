import java.util.Arrays;

public class JLS_10_6_ArrayInitialisers_2 {

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
	f(new Object[]{"abc", new Integer(2)});
	f(new Object[]{new Integer(3), new Integer(2)});
	f({1, 2L, new Object[]{"3", "4"}});
	f({1, 2, new Integer(3)});
	f({1,2,3});
	g({1,2L,3});
    }
}
