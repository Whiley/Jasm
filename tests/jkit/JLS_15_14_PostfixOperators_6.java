public class JLS_15_14_PostfixOperators_6 {
    public static void main(String[] args)  {
	int[] a = {1,2};
	int i = 0;
	try {
	    if(a[i-1] == 0 && a[i++] == 1) {
		System.out.println("GOT HERE");
	    }	
	} catch(Exception e) {
	    System.out.println("CAUGHT EXCEPTION");
	}
	System.out.println("i = " + i); 
    }
}