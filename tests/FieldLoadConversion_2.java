public class FieldLoadConversion_2 {
    int field = 1234;

    public int f(FieldLoadConversion_2 ptr) {
	int x = field;
	ptr.field = 3345;
	return field + x;
    }

    public static void main(String[] args) {
	FieldLoadConversion_2 ptr = new FieldLoadConversion_2();
	int f = ptr.f(ptr);
	System.out.println("GOT: " + f);
    }
}