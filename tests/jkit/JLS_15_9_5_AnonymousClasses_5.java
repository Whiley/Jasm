public class JLS_15_9_5_AnonymousClasses_5 {

    public String x = "JLS_15_9_5_AnonymousClasses_5.x";

    public JLS_15_9_5_AnonymousClasses_5 getAnon() {
	String x = "getAnon().x";
	return new JLS_15_9_5_AnonymousClasses_5() {
	    public String f() {
		return x;
	    }
	};
    }

    public String f() { return x; }

    public static void main(String[] args) {
	System.out.println(new JLS_15_9_5_AnonymousClasses_5().getAnon().f());
    }
}
