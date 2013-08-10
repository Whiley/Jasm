public class JLS_8_1_2_GenericTypes_23<T> {
    private T field;

    public JLS_8_1_2_GenericTypes_23(T f) {
	this.field = f;
    }

    public T get() { return field; }

    public static void print(JLS_8_1_2_GenericTypes_23<?> tmp) {
	String x = (String) tmp.get();
	System.out.println("I GOT: " + x);
    }
    
    public static void main(String[] args) {
	print(new JLS_8_1_2_GenericTypes_23<String>("Hello World"));
    }
}
