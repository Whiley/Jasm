public class JLS_15_9_5_AnonymousClasses_6 {
    public String f() {
	return "Nout";
    }    

    public JLS_15_9_5_AnonymousClasses_6 getAnon(final String f) {
	return new JLS_15_9_5_AnonymousClasses_6() {
	    public String f() { return f; }
	};
    }

    public static void main(String[] args) {
	System.out.println(new JLS_15_9_5_AnonymousClasses_6().getAnon("Hello World").f());
    }
}
