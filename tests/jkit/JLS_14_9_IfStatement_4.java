public class JLS_14_9_IfStatement_4 {
    public static void main(String[] args) {
	int x;
	int length = 10;
	while((x = length) != 0) {
	    System.out.println("GOT: " + length);
	    length = length - 1;
	}
	System.out.println("DONE");
    }
}
