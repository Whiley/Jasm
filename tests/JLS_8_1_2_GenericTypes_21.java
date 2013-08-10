public class JLS_8_1_2_GenericTypes_21<T> {
    public <E> T f(E e) {
	return (T) e;
    }

    public static void main(String[] args) {
	System.out.println(new JLS_8_1_2_GenericTypes_21<String>().f("Hello World"));
    }
}