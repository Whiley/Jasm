public class JLS_14_20_TryStatement_4 {
    public static int f(int x) {
	int[] xs = new int[10];
	return xs[x];
    }
    public static void g(int x) {	
	try {
	    f(x);
	    if(x != 100) {
		return;
	    } 
	} finally {
	    System.out.println("FINALLY " + x + " ... OK");
	}
    }

    public static void main(String[] args) {
	g(5);

	try {
	    g(20);
	} catch(ArrayIndexOutOfBoundsException e) {
	    System.out.println("FINALLY RETHROW ... OK");
	}
    }
}
