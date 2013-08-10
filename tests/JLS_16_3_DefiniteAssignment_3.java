public class JLS_16_3_DefiniteAssignment_3 {
    public static void main(String[] args) {
	int x;
	while(args != null) {
	    x = 1;
	    args = null;
	} 
	System.out.println("GOT: " + x);
    }
}
