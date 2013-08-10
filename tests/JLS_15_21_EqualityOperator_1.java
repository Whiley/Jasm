public class JLS_15_21_EqualityOperator_1 {
    public static void main(String[] args) {
	boolean x1 = true;
	boolean x2 = true;

	if(x1 == x2) {
	    System.out.println("==");
	}
	
	if(x1 != x2) {
	    System.out.println("!=");
	}
    }
}
