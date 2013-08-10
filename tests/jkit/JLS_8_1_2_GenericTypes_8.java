public class JLS_8_1_2_GenericTypes_8 {
    public static void test(Class c) {
	System.out.println("CLASS: " + c.getName());
    }

    public static void main(String[] args) {
	Class c = String.class;
	test(c);
	test(String.class);
    }
}
