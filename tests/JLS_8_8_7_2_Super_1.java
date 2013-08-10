public class JLS_8_8_7_2_Super_1 {    

    static class Sub_1 extends JLS_8_8_7_2_Super_1 {

	public Sub_1(String name) {
	    super(name);
	    System.out.println("SUB CONSTRUCTOR CALLED: " + name);
	}

	public void f() {
	    super.f();
	    System.out.println("SUB F CALLED");
	}
    }

    public JLS_8_8_7_2_Super_1(String name) {
	System.out.println("SUPER CONSTRUCTOR CALLED: " + name);
    }

    public void f() {
	System.out.println("SUPER F CALLED");
    }

    public static void main(String[] args) {
	new Sub_1("Test").f();
    }
}
