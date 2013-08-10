import java.util.Map;

public class TypeBounds_9<H> {
    private static class Inner {
	public String get() {
	    return "Hello";
	}
	/*
	public H getH() {
	    return null;
	}
	*/
    }

    public static void main(String[] args) {
	TypeBounds_9<Integer>.Inner i = new Inner();
	String s = i.get();
	System.out.println(s);
    }
}
