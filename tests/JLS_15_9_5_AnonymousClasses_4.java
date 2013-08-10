public class JLS_15_9_5_AnonymousClasses_4 {
    public static class Inner {
	public String f() { return "nothing"; }
    }

    private static String outer = "Hello World";

    static JLS_15_9_5_AnonymousClasses_4.Inner field = new JLS_15_9_5_AnonymousClasses_4.Inner() {
	    public String f() { return outer; }
	};
    
    public static void main(String[] args) {	
	System.out.println(field.f());
    }
}
