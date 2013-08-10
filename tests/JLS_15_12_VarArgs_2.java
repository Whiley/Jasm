public class JLS_15_12_VarArgs_2 {

    public void f(Integer x, String... args) {
	System.out.println("x = " + x);
	for(String s : args) {
	    System.out.println(s);
	}
    }

    public static void main(String[] args) {
	new JLS_15_12_VarArgs_2().f(1);
    }
}
