public class JLS_14_11_SwitchStatement_6 {
    public static void main(String[] args) {
	int y = 2;
	final int z = 0;

	switch(args.length) {
	case 1:
	    System.out.println("GOT 0");
	    break;
	case z:
	    System.out.println("GOT Z");
	    break;
	}       	
    }
}
