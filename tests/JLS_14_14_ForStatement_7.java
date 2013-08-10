public class JLS_14_14_ForStatement_7 {

    public static void main(String[] args) {
	for(int j=4;j!=10;++j) {
	    scan: {
		System.out.println("BEFORE LOOP");
		for (int i = 0; i < 5; i++) {		
		    System.out.println("L1: " + i);
		    if(i == j) {
			System.out.println("BREAKING L1");
			break scan;
		    }
		}

		for (int i = 5; i < 10; i++) {
		    System.out.println("L2: " + i);
		    if(i == j) {
			System.out.println("BREAKING L2");
			break scan;
		    }
		}
	    }
	}
    }
}
