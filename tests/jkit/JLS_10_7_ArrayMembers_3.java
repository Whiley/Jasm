public class JLS_10_7_ArrayMembers_3 {
    public static void main(String[] args) {
	int[] arr = null;
	try {
	    int x = arr[0];
	} catch(Exception e) {
	    System.out.println("CAUGHT IT!");
	}
    }
}