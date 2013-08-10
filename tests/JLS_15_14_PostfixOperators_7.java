public class JLS_15_14_PostfixOperators_7 {
    public static void main(String[] args)  {
	String s = null;
	int i = 0;
	try {
	    if(s.length() == 0 && i++ == 1) {
		System.out.println("GOT HERE");
	    }	
	} catch(Exception e) {
	    System.out.println("CAUGHT EXCEPTION");
	}
	System.out.println("i = " + i); 
    }
}