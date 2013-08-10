public class JLS_14_20_TryStatement_9 {
    public static void main(String[] args) { 
	int i = 1;
	try { 
	    switch(i) {
	    case 1:
		return;
	    }
	} finally { 
	    System.out.println("Finally"); 
	}
    }    
}
