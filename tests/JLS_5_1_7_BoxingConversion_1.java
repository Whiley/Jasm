public class JLS_5_1_7_BoxingConversion_1 {
    public static void g(Integer x) {
	System.out.println("GOT " + x);
    }

    public static void f(int x) {
	System.out.println("GOT " + x);
    }

    public static void main(String[] args) {
	int a = 1;	
	Integer b = new Integer(2);
	g(a);
	f(b);
    }
}
