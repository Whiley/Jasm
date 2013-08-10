import static pkg.TestHelper.Inner;

public class JLS_7_5_3_StaticImport_5 {
    public void f(Inner k) {
	System.out.println("Hello World");
    }

    public static void main(String[] args) {
	new JLS_7_5_3_StaticImport_5().f(null);
    }
}