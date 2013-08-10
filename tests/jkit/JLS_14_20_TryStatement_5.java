public class JLS_14_20_TryStatement_5 {
    public static void main(String[] args) {
	int[] array = new int[101];
	
	// The aim of these test cases are to check for exceptions
	// arising from conditions (which become edge conditions)
	try {
	    if(array[101] == 0) {
		System.out.println("SHOULDN'T GET HERE");
	    }
	} catch(Exception e) {
	    System.out.println("CAUGHT Exception from If");
	}

	try {
	    for(int i=0;array[i] != 10; ++i) {
		i = i + 1;
	    }
	} catch(Exception e) {
	    System.out.println("CAUGHT Exception from For");
	}
    }
}
