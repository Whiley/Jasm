public class JLS_5_1_7_BoxingConversion_5 {
    public static void main(String[] args) {
	Object o = new Boolean(true);
	boolean b = !((Boolean)o);
	System.out.println(b);
    }
}
