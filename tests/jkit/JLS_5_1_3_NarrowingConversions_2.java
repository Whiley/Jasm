public class JLS_5_1_3_NarrowingConversions_2 {
    public char f() {
	return 0xFFFF;
    }

    public static void main(String[] args) {
	System.out.println(new JLS_5_1_3_NarrowingConversions_2().f());
    }
}
