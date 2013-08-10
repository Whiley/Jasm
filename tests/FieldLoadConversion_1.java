public class FieldLoadConversion_1 {
    int field = 1234;

    public void g() {
	field = 34875;
    }    

    public int f() {
	int x = field;
	g();
	return field + x;
    }

    public static void main(String[] args) {
	int f = new FieldLoadConversion_1().f();
	System.out.println("GOT: " + f);
    }
}