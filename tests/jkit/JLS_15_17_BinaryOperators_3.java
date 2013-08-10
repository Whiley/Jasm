public class JLS_15_17_BinaryOperators_3 {
    static final long[] jjtoToken = {
	0xfffffffff8000fffL, 0xfffffffffe11ffffL, 0x1fffL, 
    };

    int jjmatchedKind = 21;

    public void f() {
	if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L) {
	    System.out.println("HELLO WORLD");
	} else {
	    System.out.println("BOO");
	}
    }

    public static void main(String[] args) {
	new JLS_15_17_BinaryOperators_3().f();
    }
}