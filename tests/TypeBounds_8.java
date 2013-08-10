import java.util.Map;

public class TypeBounds_8<K> {
    private static interface Inter<K> {
	K get();
    }
    private static class Inner implements Inter<String> {
	public String get() {
	    return "Hello";
	}
    }

    public static void main(String[] args) {
	Inner i = new Inner();
	String s = i.get();
	System.out.println(s);
    }
}
