public class FieldLoadConversion_5 {

    int field = 14874;

    public void g() {
	field = -124393;
    }
   
    public int f(FieldLoadConversion_5 ptr, int x) {
	if(ptr != null) {
	    x += ptr.field;
	    g();
	    x += ptr.field;
	}
	return x;
    }

    public static void main(String[] args) {
	FieldLoadConversion_5 ptr = new FieldLoadConversion_5();
	System.out.println(ptr.f(ptr,1234));
	System.out.println(ptr.f(null,14));
    }
}