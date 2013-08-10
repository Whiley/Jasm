public class JLS_14_20_TryStatement_3 {
    public static void f() {
	throw new ArrayIndexOutOfBoundsException("Got here");
    }
    public static void main(String args[]) {
	try {
	    f();
	} catch(ArrayIndexOutOfBoundsException e) {
	    System.out.println("RIGHT ONE");
	} catch(Exception e) {
	    System.out.println("WRONG ONE");
	}
	try {
	    f();
	} catch(ArrayIndexOutOfBoundsException e) {
	    System.out.println("RIGHT ONE");
	} catch(Exception e) {
	    System.out.println("WRONG ONE");
	}
    }
}
