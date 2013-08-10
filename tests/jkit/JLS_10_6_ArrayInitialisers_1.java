import java.util.Arrays;

public class JLS_10_6_ArrayInitialisers_1 {
	public static void main(String[] args) {
	    Object[] test = new Object[]{"abc", new Integer(2)};
	    for(Object o : test) {
		System.out.println(o);
	    }
	    Object[] test2 = new Object[]{new Integer(3), new Integer(2)};

	    for(Object o : test2) {
		System.out.println(o);
	    }


	    Object[] test3 = {1, 2L, new Object[]{"3", "4"}};
	    for(Object o : test3) {
		if(o instanceof Object[]) {
		    System.out.println(Arrays.toString((Object[])o));
		} else {
		    System.out.println(o);
		}
	    }

	    Integer[] test4 = {1, 2, new Integer(3)};
	    for(Object o : test4) {
		System.out.println(o);
	    }


	    Object[] test5 = {1,2,3};
	    for(Object o : test5) {
		System.out.println(o);
	    }

 
	    long[] test6 = {1,2L,3};
	    for(long o : test6) {
		System.out.println(o);
	    }
	}
}
