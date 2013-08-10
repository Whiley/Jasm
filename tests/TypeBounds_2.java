public class TypeBounds_2<T extends String> {
    public TypeBounds_2(T x) { System.out.println("GOT: " + x); }
    public static void main(String[] args) {
	// should fail
	new TypeBounds_2<Integer>(1);
    }
}
