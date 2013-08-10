public class JLS_14_11_SwitchStatement_1 {
    public static void main(String[] args) {
	switch(args.length) {
	case 0:
	    System.out.println("SWITCH 1 ... OK");
	    break;
	case 1:
	case 2:
	case 3:
	case 4:
	    System.out.println("ERROR");	    
	}

	switch(args.length) {
	case 2:
	    System.out.println("ERROR");
	    break;
	case 1:
	case 3:
	case 4:
	    System.out.println("ERROR");	    
	default:
	    System.out.println("SWITCH 2 ... OK");	    
	}

	switch(args.length) {
	case 0:
	case 1:
	    System.out.println("SWITCH 3 ... OK");	    
	    break;
	case 2:
	case 3:
	case 4:
	    break;
	default:
	    System.out.println("ERROR");	    
	}

	// this one should force lookup switch
	switch(args.length) {
	case 0:
	    System.out.println("SWITCH 4 ... OK");
	    break;
	case 16:
	    System.out.println("ERROR");	    
	}
    }
}
