public class JLS_14_20_TryStatement_1 {
    public static int f(int x) throws ArrayIndexOutOfBoundsException {
	int[] xs = new int[10];
	return xs[x];
    }
    public static int g(int x) throws Exception {
	int[] xs = new int[10];
	return xs[x];
    }

    public static void main(String[] args) {
	try {
	    throw new RuntimeException("Exception 1");
	} catch(Exception e) {
	    System.out.println("Exception 1 ... OK");
	} finally {
	    System.out.println("Finally 1 ... OK");
	}

	try {
	    throw new Exception("Exception 2");
	} catch(RuntimeException e) {
	} catch(Exception e) {
	    System.out.println("Exception 2 ... OK");
	} finally {
	    System.out.println("Finally 2 ... OK");
	}
	
	try {
	    f(25);
	} catch(RuntimeException e) {
	    System.out.println("Exception 3 ... OK");
	} catch(Exception e) {
	} finally {
	    System.out.println("Finally 3 ... OK");
	}

	try {
	    g(25);
	} catch(RuntimeException e) {
	    System.out.println("Exception 4 ... OK");
	} catch(Exception e) {
	} finally {
	    System.out.println("Finally 4 ... OK");
	} 	
    }
}
