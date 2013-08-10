public class JLS_15_12_VarArgs_4 {

    public void f(Integer x, Object... args) {
	System.out.println("x = " + x);
	for(Object o : args) {
	    System.out.println(o);
	}
    }

    public static void main(String[] args) {
	JLS_15_12_VarArgs_4 x = new JLS_15_12_VarArgs_4();
	x.f(1,"Hello",1);
    }
}
