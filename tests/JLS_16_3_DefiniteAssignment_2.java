public class JLS_16_3_DefiniteAssignment_2 {
    public static void main(String[] args) {
	int x;
	if(args == null) {
	    x = 1;
	}
	System.out.println("GOT: " + x);
    }
}
