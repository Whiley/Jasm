public class JLS_14_10_Assert_1 {
    public static void main(String[] args) {
	int i = 0;
	assert i++ == 1;
	System.out.println("GOT " + i);
    }
}
