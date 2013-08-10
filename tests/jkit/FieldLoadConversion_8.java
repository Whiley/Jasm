public class FieldLoadConversion_8 {

    int field = 14874;

    public void h(int x, int y) {
	System.out.println("X: " + y);
	System.out.println("Y: " + y);
    }

    public int g() {
	int ofield = field;
	field = -124393;
	return ofield;
    }
   
    public int f(int x) {
	x += field;
	h(g(),field);
	x += field;
	h(field,g());
	return x;
    }

    public static void main(String[] args) {
	FieldLoadConversion_8 ptr = new FieldLoadConversion_8();
	System.out.println(ptr.f(1234));
    }
}