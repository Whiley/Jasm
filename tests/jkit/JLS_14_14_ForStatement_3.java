public class JLS_14_14_ForStatement_3 {
    public static void main(String[] args) {
	int x=0;
	int y = 10;
	for(int i=(++x);i!=(--y);i=i+1) {
	    System.out.println("GOT: " + i);
	}
    }
}
