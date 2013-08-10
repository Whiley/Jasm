public class HeapException_1 {    
    public static void main(String[] args) {
	
	// Attempt to exhaust physical memory
	try {
	    int max = 1024*10;
	    int[][] arr = new int[max][];	
	    for(int i=0;i!=max;++i) {
		arr[i] = new int[1024*1024]; // >1MB chunk
	    }
	} catch(OutOfMemoryError e) {
	    System.out.println("CAUGHT HEAP EXCEPTION");
	}
    }
}
