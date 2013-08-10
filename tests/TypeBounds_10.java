import java.util.Map;

public class TypeBounds_10<H> {
    private static class Inner {
	public String get() {
	    return "Hello";
	}
	public H getH() {
	    return null;
	}
    }

    public static void main(String[] args) {
	Inner i = new Inner();
	String s = i.get();
	System.out.println(s);
    }
}
