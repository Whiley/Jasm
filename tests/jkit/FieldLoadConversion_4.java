public class FieldLoadConversion_4 {

    int field = 14874;

    public void g() {
	field = -124393;
    }
   
    public int f(FieldLoadConversion_4 ptr, int x) {
	if(x > 100) {
	    x += ptr.field;
	    g();
	    x += ptr.field;
	}
	x += ptr.field;
	return x;
    }

    public static void main(String[] args) {
	FieldLoadConversion_4 ptr = new FieldLoadConversion_4();
	System.out.println(ptr.f(ptr,1234));
	System.out.println(ptr.f(ptr,14));
    }
}