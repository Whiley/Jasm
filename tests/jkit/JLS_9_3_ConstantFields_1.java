public class JLS_9_3_ConstantFields_1 {	
    public static interface Inter {
	public final int CONSTANT = 1246352;
    }

    public static class Inner extends JLS_9_3_ConstantFields_1 implements Inter {
    }

    public static void main(String[] args) {
	Inner i = new Inner();
	System.out.println(i.CONSTANT);
    }
}
