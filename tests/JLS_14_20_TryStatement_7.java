public class JLS_14_20_TryStatement_7 {
    public static void main(String[] args) {	
	try {
	    try {
		int x = 10 / args.length;
	    } finally {
		System.out.println("FINALLY");
	    }	    
	} catch(ArithmeticException e) {
	    System.out.println("CAUGHT ARITH EXCEPTION");
	} finally {
	    System.out.println("DONE");
	}
    }
}
