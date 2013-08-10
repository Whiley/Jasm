public class JLS_15_25_ConditionalOperator_1 {
    public static void main(String[] args) {
	int x = 0;
	int y = ((x=1) == 1) ? (x=3)+2 : (x=4)+5;
	System.out.println(x);
	System.out.println(y);
    }
}
