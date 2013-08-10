public class TypeBounds_3 {
    public String x;
    public <T extends String> void f(T y) {
	x = y;
	System.out.println("GOT: " + x);
    }

    public static void main(String[] args) {
	TypeBounds_3 x = new TypeBounds_3();
	x.f("Hello");	
    }
}
