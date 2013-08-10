public class TypeBounds_12<T> {
    TypeBounds_12<? super T> field;

    public TypeBounds_12() {}

    public TypeBounds_12(TypeBounds_12<? super T> f) {
	// an example like this occurs in java/lang/ref/Reference.java
	this.field = f == null ? new TypeBounds_12() : f;
	System.out.println("GOT: " + f);
    }

    public static void main(String[] args) {
	new TypeBounds_12(null);
    }
}
