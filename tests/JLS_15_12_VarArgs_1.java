public class JLS_15_12_VarArgs_1 {
    public void f(Integer x, String... args) {
	System.out.println("x = " + x);
	for(String s : args) {
	    System.out.println(s);
	}
    }

    public static void main(String[] args) {
	JLS_15_12_VarArgs_1 x = new JLS_15_12_VarArgs_1();
	x.f(1,"Hello","World");
    }
}
