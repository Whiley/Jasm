public class JLS_15_9_5_AnonymousClasses_8 {
    public static class Inner {
	public String f() { return "nothing"; }
    }

    private String outer = "Hello World";

    public Inner getInner() {
	return new Inner() {
	    public String f() { return outer; }
	};
    }

    public static void main(String[] args) {
	System.out.println(new JLS_15_9_5_AnonymousClasses_8().getInner().f());
    }
}
