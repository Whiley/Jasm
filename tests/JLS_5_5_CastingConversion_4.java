public class JLS_5_5_CastingConversion_4<T extends Number> {
    public T f(Object o) {
	return (T) o;
    }

    public static void main(String[] args) {
	JLS_5_5_CastingConversion_4<Integer> x = new JLS_5_5_CastingConversion_4<Integer>();
	Integer f = x.f(1);
	System.out.println(f);
    }
}
