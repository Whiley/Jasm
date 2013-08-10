public class TypeBounds_11 implements TypeBounds_11_Helper.Inter<String> {
    public String get() {
	return "Hello";
    }
    public static void main(String[] args) {
	TypeBounds_11 x = new TypeBounds_11();
	System.out.println(x.get());
    }
}

