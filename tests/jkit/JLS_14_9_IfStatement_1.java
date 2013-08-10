public class JLS_14_9_IfStatement_1 {
    public static void main(String[] argv) {
	f(false,'x');
    }
    public static int f(boolean b, char c) {
	if (!b || c != 'c') return 2;
        return 0;
    }
}
