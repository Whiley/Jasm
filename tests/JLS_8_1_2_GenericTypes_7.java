public class JLS_8_1_2_GenericTypes_7<E> {
    void method1() {
	E obj = method2();
    }

    E method2() {
	return null;
    }
    public static void main(String[] args) {
	System.out.println("GOT: " + new JLS_8_1_2_GenericTypes_7<String>().method2());
    }
}
