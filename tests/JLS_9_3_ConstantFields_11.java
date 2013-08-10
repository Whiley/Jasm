public class JLS_9_3_ConstantFields_11 {
    public static final int CONSTANT = 12345;

    public static void print(int x) {
	switch(x) {
	case JLS_9_3_ConstantFields_11_Helper.CONSTANT:
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
