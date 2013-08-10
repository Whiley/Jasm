public class JLS_14_11_SwitchStatement_2 {

    public static void main(String[] args) {
	for(int i=0;i!=10;++i) {
	    switch(i) {
	    case 0:
		System.out.println("CASE 0 ... OK");
		break;
	    case 1:
	    case 2:
		System.out.println("CASE 1/2 ... OK");
		break;
	    case 3:
		System.out.println("CASE 3 ... OK");
	    case 4:
		System.out.println("CASE 3/4 ... OK");
		break;
	    case 5:
		// This case is added since the initial implementation
		// of switch statements used a loopscope, meaning that
		// continue statements would not work correctly.
		continue;
	    case 6:
		int j=0;
		for(;j!=5;++j) {
		    if(j == 5) { break; }
		}
		if(j == 5) { System.out.println("CASE 6 ... OK"); }
		break;
	    }
	    if(i == 5) {
		System.out.println("CONTINUE ERROR");
	    }
	}

	// This example also caused a problem with the initial version of switch
	switch(args.length) {
	case 0:
	    System.out.println("CASE 1");
	default:
	    System.out.println("DEFAULT");
	}
    }
}
