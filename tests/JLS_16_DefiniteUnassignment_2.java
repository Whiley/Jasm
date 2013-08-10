// Test definite non-assignment.
public class JLS_16_DefiniteUnassignment_2 {
    public static void main(String[] args) {
	final int x = 1;
	if(args == null) {
	    System.out.println("Hello");
	}
	x = 2;

    }
}
