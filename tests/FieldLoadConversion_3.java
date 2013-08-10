public class FieldLoadConversion_3 {
    FieldLoadConversion_3 next;
    int field = 1234;

    public int f(FieldLoadConversion_3 ptr) {
	int x = ptr.field;
	ptr.next.field = 3345;
	return ptr.field + x;
    }

    public static void main(String[] args) {
	FieldLoadConversion_3 ptr = new FieldLoadConversion_3();
	ptr.next = ptr;
	int f = ptr.f(ptr);
	System.out.println("GOT: " + f);
    }
}