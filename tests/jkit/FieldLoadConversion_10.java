public class FieldLoadConversion_10 {

    int field = 14874;

    public void g() {
	field = -124393;
    }
   
    public int f(FieldLoadConversion_10 ptr, String dummy, int x) {
	if(dummy != null) {
	    x += ptr.field;
	    g();
	    x += ptr.field;
	}
	return x;
    }

    public static void main(String[] args) {
	FieldLoadConversion_10 ptr = new FieldLoadConversion_10();
	System.out.println(ptr.f(ptr,"Hello",1234));
	System.out.println(ptr.f(null,null,14));
    }
}