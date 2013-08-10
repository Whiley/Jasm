public class TypeBounds_5<T extends Integer> {
    public void f(T y) {
	double x = y.doubleValue();
	System.out.println("GOT: " + x);
    }

    public static void main(String[] args) {
	TypeBounds_5 x = new TypeBounds_5();
	x.f(new Integer(53));	
    }
}
