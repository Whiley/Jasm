// Test definite non-assignment.
public class JLS_16_DefiniteUnassignment_3 {
    public static void main(String[] args) {
	final int x;
	while(args != null) {
	    x = 1;
	    args = null;
	}
	x = 2;

    }
}
