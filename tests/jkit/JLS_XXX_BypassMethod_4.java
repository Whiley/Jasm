public class JLS_XXX_BypassMethod_4 {
    public static interface Inter {
	public Number f();
    }

    public static class Child implements Inter {
	public Integer f() {
	    return 12321;
	}
    }

    public static void p1(Integer i) {
	System.out.println("GOT INTEGER: " + i);
    }

    public static void p2(Number i) {
	System.out.println("GOT NUMBER: " + i);
    }

    public static void main(String[] args) {
	JLS_XXX_BypassMethod_4.Child tc = new JLS_XXX_BypassMethod_4.Child();
	JLS_XXX_BypassMethod_4.Inter ti = tc;
	p1(tc.f());
	p2(ti.f());
    }
}
