// Test definite non-assignment.
public class JLS_16_DefiniteUnassignment_1 {
    public static void main(String[] args) {
	final int x;
	if(args == null) {
	    x = 1;
	} else {
	    x = 2;
	}
	System.out.println("GOT: " + x);
    }
}
