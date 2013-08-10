public class JLS_15_13_ArrayAccess_4 {
    public static void main (String args[]) {
	int[] a = new int[256];
	a[' '] = 123;
	System.out.println(a[32]);
    }
}