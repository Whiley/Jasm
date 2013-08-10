public class JLS_15_9_5_AnonymousClasses_9 {
    public static class Inner {
	public void f(String x) { outer = "blah"; }
    }

    private static String outer = "Hello World";
    
    public static void main(String[] args) {
	JLS_15_9_5_AnonymousClasses_9.Inner t = new JLS_15_9_5_AnonymousClasses_9.Inner() {
		public void f(String x) { outer = x; }
	    };
	t.f("Got it");
	System.out.println(outer);
    }
}
