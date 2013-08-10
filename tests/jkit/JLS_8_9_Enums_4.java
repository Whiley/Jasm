public class JLS_8_9_Enums_4 {

    public enum Inner {
	OTHER(null);

	final Object field;

	Inner(Object o) {
	    field = o;
	}

	public String toString() {
	    return "OTHER(" + field + ")";
	}
    }

    public static void main(String[] args) {
	Inner x = Inner.OTHER;
	System.out.println("GOT: " + x);
    }
}