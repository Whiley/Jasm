public class JLS_9_3_ConstantFields_10 {
    private static final int CONSTANT = JLS_9_3_ConstantFields_10_Helper.CONSTANT;

    public static void print(int x) {
	switch(x) {
	case CONSTANT:
	    System.out.println("GOT THE CONSTANT (" + x + ")");
	    break;
	default:
	    System.out.println("DIDN'T GET THE CONSTANT");
	}
    }

    public static void main(String[] args) {
	print(CONSTANT);
    };
}
