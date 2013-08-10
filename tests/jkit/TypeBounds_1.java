public class TypeBounds_1<T extends String> {
    public String x;
    public TypeBounds_1(T y) {
	x = y;
	System.out.println("GOT: " + x);
    }
    public static void main(String[] args) {
	new TypeBounds_1<String>("Hello");
    }
}
