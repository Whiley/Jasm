public class JLS_15_14_PostfixOperators_8 {
    public static void main(String[] args)  {
	int[] a = {0,2};
	int i = 0;
	if(a[i++] == 0 || a[i++] == 1) {
	    System.out.println("Got here");
	}
	System.out.println("i = " + i);
    }
}