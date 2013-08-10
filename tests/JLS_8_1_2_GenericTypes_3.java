public class JLS_8_1_2_GenericTypes_3<T> {
    private T x;

    public JLS_8_1_2_GenericTypes_3(T x) {
	this.x = x;
    }

    public void f() {
	if(x != null) {
	    System.out.println("NOT NULL (1)");
	} else {
	    System.out.println("IS NULL (1)");
	}

	if(null != x) {
	    System.out.println("NOT NULL (2)");
	} else {
	    System.out.println("IS NULL (2)");
	}
    }

    public static void main(String[] argv) {
	new JLS_8_1_2_GenericTypes_3<String>("Hello").f();
	new JLS_8_1_2_GenericTypes_3<String>(null).f();
    }
}
