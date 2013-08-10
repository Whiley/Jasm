public class JLS_16_3_DefiniteAssignment_4 {
    public static void main(String[] args) {
	int x;

	try {
	    x = 1/0;
	} catch(Exception e) {}
	System.out.println("GOT: " + x);
    }
}
