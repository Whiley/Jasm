public class JLS_5_5_CastingConversion_3<T> {
    public T f(Object o) {
	return (T) o;
    }

    public static void main(String[] args) {
	JLS_5_5_CastingConversion_3<String> x = new JLS_5_5_CastingConversion_3<String>();
	String f = x.f("Hello World");
	System.out.println(f);
    }
}
