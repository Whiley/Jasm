public class FieldLoadConversion_7 {

    int field = 14874;

    public void h(int h) {
	System.out.println("H: " + h);
    }

    public FieldLoadConversion_7 g() {
	field = -124393;
	return this;
    }
   
    public int f(int x) {
	x += field;
	g().h(field);
	return x;
    }

    public static void main(String[] args) {
	FieldLoadConversion_7 ptr = new FieldLoadConversion_7();
	System.out.println(ptr.f(1234));
    }
}