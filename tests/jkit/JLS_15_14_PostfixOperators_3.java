public class JLS_15_14_PostfixOperators_3 {
    public void f(int a, int b, int c) {
	System.out.println(a);
	System.out.println(b);
	System.out.println(c);
    }
    public static void main(String[] args) {
	int x = 0;
	new JLS_15_14_PostfixOperators_3().f(x,x++,x);
    }
}
