public class FieldLoadConversion_6 {

    int field = 14874;

    public void g() {
	field = -124393;
    }
   
    public int f(FieldLoadConversion_6 ptr, int x) {
	try {
	    x += ptr.field;
	    g();
	    x += ptr.field;
	} catch(NullPointerException e) {
	    System.out.println("GOT NULL POINTER EXCEPTION");
	}
	return x;
    }

    public static void main(String[] args) {
	FieldLoadConversion_6 ptr = new FieldLoadConversion_6();
	System.out.println(ptr.f(ptr,1234));
	System.out.println(ptr.f(null,14));
    }
}