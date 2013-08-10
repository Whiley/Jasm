public class JLS_14_20_TryStatement_10 {
	public static void main(String args[]) {
	    args = null;
	    try {
		args[0] = "Hello";
	    } catch (final Exception e) {
		System.out.println("CAUGHT EXCEPTION");
	    }
	}
}
