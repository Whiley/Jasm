public class JLS_14_11_SwitchStatement_11 {
    public static void main(String[] args) {
	switch(args.length) {
	case 1:
	    System.out.println("0");
	    break;
	case 2:
	    System.out.println("2");
	    break;
	case 0:
	    System.out.println("1");
	    break;
	}
    }
}
