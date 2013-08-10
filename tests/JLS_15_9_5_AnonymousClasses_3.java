public class JLS_15_9_5_AnonymousClasses_3 {
    public static class Inner {
	public String f() { return "nothing"; }
    }

    private static String outer = "Hello World";
    
    public static void main(String[] args) {
	JLS_15_9_5_AnonymousClasses_3.Inner t = new JLS_15_9_5_AnonymousClasses_3.Inner() {
		public String f() { return outer; }
	    };
	System.out.println(t.f());
    }
}
