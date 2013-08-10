public class FieldLoadConversion_9 {

    int field = 0;

    public void h(int h) {
	System.out.println("H: " + h);
    }

    public int[] g() {
	field = 1;
	return new int[]{11,22,33,44,55,66};
    }
   
    public int f(int x) {
	return x + g()[field];
    }

    public static void main(String[] args) {
	FieldLoadConversion_9 ptr = new FieldLoadConversion_9();
	System.out.println(ptr.f(1234));
    }
}