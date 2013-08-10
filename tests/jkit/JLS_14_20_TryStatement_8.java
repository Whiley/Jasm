public class JLS_14_20_TryStatement_8 {
    public static void main(String[] args) { 
	int i = 6;
	try { 
	    i = i + 1; 
	} finally { 
	    try { 
		i = i * 8211; 
		switch(i) {
		case 57477:
		    System.out.println("CASE 1 OK");
		    break;
		default:
		    System.out.println("CASE 1 NOT OK");
		}
	    } finally { 
		i = i + 456; 
		switch(i) {
		case 57933:
		    System.out.println("CASE 2 OK");
		    break;
		default:
		    System.out.println("CASE 2 NOT OK");
		}
	    } 
	}
	System.out.println(i);
	System.exit(i); 
    }    
}
