public class JLS_8_1_3_InnerClasses_6 {
    private static String outer = "Hello World";

    public static class Inner {
	public void f(String x) { outer = x; }
    }
    
    public static void main(String[] args) {
	JLS_8_1_3_InnerClasses_6.Inner t = new JLS_8_1_3_InnerClasses_6.Inner();
	t.f("Got it");
	System.out.println(outer);
    }
}
