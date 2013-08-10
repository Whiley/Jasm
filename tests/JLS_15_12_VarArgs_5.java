public class JLS_15_12_VarArgs_5 {

    public void f(Integer x, String... args) {
	System.out.println("x = " + x);
	for(String s : args) {
	    System.out.println(s);
	}
    }

    public static void main(String[] args) {
	JLS_15_12_VarArgs_5 x = new JLS_15_12_VarArgs_5();
	String[] xs = new String[2];
	xs[0] = "Hello";
	xs[1] = "World";
	x.f(1,xs);
    }
}
