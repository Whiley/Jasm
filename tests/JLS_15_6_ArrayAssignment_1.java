public class JLS_15_6_ArrayAssignment_1 {
    public static void main (String args[]) {
	int[] xs = new int[10];
	int[] ys = new int[0];

	try {
	    Float[] zs = new Float[10];
	    ((Object[])zs)[9] = 1;
	} catch(ArrayStoreException e) {
	    System.out.println("ARRAY STORE 1 ... OK");	    
	}

	try {
	    Object zs = new Object[10][10];
	    ((Object[])zs)[0] = new int[10];
	} catch (ArrayStoreException e) {
	    System.out.println("ARRAY STORE 2 ... OK");	    
	}
    }
}
