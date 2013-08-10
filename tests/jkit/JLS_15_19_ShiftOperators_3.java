public class JLS_15_19_ShiftOperators_3 {
    static long[] asciiMoves = new long[2];

    private static final void f(char c) {
	asciiMoves[c / 64] |= (1L << (c % 64));
    }

    public static void main(String[] args) {
	char c = 'D';
	f(c);
	System.out.println("Hello World");
    }
}