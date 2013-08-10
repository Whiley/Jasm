public class JLS_8_8_7_2_Super_4 {    
    static class Sub_1 extends JLS_8_8_7_2_Super_4 {
	public void f() {
	    super.f();
	    System.out.println("SUB F CALLED");
	}
    }

    public void f() {
	System.out.println("SUPER F CALLED");
    }

    public static void main(String[] args) {
	new Sub_1().f();
    }
}
