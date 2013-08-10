public class JLS_8_1_3_InnerClasses_7 {
    private String outer = "Hello World";

    public class Inner {
	public void f(String x) { outer = x; }
    }

    public Inner getInner() { return new Inner(); }

    public static void main(String[] args) {
	JLS_8_1_3_InnerClasses_7 t = new JLS_8_1_3_InnerClasses_7();
	JLS_8_1_3_InnerClasses_7.Inner inner = t.getInner();
	inner.f("Got it");
	System.out.println(t.outer);
    }
}
