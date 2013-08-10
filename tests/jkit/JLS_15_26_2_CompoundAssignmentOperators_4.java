public class JLS_15_26_2_CompoundAssignmentOperators_4 {
    public static void main(String args[]) {
	double angle = 1.0;
	
	angle %= Math.PI / 2;

	System.out.println(angle);
    }    
}