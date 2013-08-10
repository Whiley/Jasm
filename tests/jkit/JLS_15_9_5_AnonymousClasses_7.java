public class JLS_15_9_5_AnonymousClasses_7 {
    public String f() {
	return "TEST";
    }

    public JLS_15_9_5_AnonymousClasses_7 getAnon(final String f) {
	return new JLS_15_9_5_AnonymousClasses_7() {
	    public String f() { return f + f; }
	};
    }
    

    public static void main(String[] args) {
	System.out.println(new JLS_15_9_5_AnonymousClasses_7().getAnon("Outer").f());
    }
}
