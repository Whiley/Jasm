import java.util.*;

// This test case represented a bug in JKit.

public class JLS_14_14_ForStatement_6 {
    public static void main(String args[]) {
	int[] xs = {0,1,2,3,4,5,6,7,8,9,10};

	for(Integer s : xs) {
	    if(s < 7)
		continue;

	    System.out.println(s);
	}
    }
}
