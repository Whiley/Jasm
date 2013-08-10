public class JLS_15_17_1_MultiplicationOperator_2 {	
    
    public double m = 0.1234;

    public double f() {
	return 6.01223D * m;
    }

    public static void main(String[] args) {
	System.out.println(new JLS_15_17_1_MultiplicationOperator_2().f());
    }
}
