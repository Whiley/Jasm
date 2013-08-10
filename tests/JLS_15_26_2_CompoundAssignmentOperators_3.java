public class JLS_15_26_2_CompoundAssignmentOperators_3 {
    public static void main(String[] args) {
	int[] xs = {1};
	int i=0;
	xs[i++] += 1;
	System.out.println(i);
    }
}
