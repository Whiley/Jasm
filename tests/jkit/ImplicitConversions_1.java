public class ImplicitConversions_1 {
    public static void main(String[] args) {
	int l1 = args.length;
	long l2 = args.length;
	
	if(l1 == l2) {
	    System.out.println("OK");
	}
    }
}
