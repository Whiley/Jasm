public class JLS_15_13_ArrayAccess_3 {
    public static void main (String args[]) {
	int[] xs = new int[10];
	int[] ys = new int[0];

	try {
	    ys[1] = 1;
	} catch(ArrayIndexOutOfBoundsException e) {
	    System.out.println("ARRAY OUT OF BOUNDS ... OK");	    
	}
    }
}
