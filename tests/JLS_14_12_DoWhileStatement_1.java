public class JLS_14_12_DoWhileStatement_1 {
    public static void main(String[] args) {
	int i=0;
	do {
	    System.out.println(i++);
	    if(i == 5) {
		break;
	    }
	} while(i!=10);
    }
}
