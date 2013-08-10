// Test definite non-assignment.
public class JLS_16_DefiniteUnassignment_4 {
    public static void main(String[] args) {
	final int x;
	try {
	    x = 1;
	} catch(Exception e) {
	    x = 2;
	}
    }
}
