// this test shouldn't compile!
public class JLS_14_11_SwitchStatement_7 {
    public static void main(String[] args) {
	int y = 1;
	switch(args.length) {
	case 0:
	    System.out.println("HELLO");
	    break;
	case y:
	    System.out.println("HELLO");
	    break;
	}
    }
}
