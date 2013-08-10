public class TypeBounds_7<T extends Number> {
    private T t;

    public TypeBounds_7(T t) {
	this.t = t;
    }
    
    public T get() { return t; }

    public static void main(String[] args) {
	TypeBounds_7<Integer> t = new TypeBounds_7<Integer>(1);
	System.out.println("GOT: " + t.get());
    }
}
