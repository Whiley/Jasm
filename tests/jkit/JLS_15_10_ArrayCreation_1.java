public class JLS_15_10_ArrayCreation_1 {
    public static void main (String args[]) {
	try {
	    int[] zs = new int[-10];
	} catch(NegativeArraySizeException e) {                  
	    System.out.println("NEGATIVE ARRAY ... OK");
	}

    }
}
