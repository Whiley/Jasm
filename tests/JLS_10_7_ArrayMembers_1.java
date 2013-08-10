public class JLS_10_7_ArrayMembers_1 {
    public static void main(String[] args) {
	// how to mess up your parser!
	try {
	    System.out.println((args = null).length);
	} catch(Exception e) {
	    System.out.println("CAUGHT IT!");
	}
    }
}
