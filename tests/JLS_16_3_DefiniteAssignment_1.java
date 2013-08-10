public class JLS_16_3_DefiniteAssignment_1 {
    public static void main(String[] args) {
	int x,y;
	x = y + 1;
	System.out.println("GOT: " + x);
    }
}
