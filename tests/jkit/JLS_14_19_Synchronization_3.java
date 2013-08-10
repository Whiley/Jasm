public class JLS_14_19_Synchronization_3 {
    int value(int f) {
	synchronized(this) {
	    if(f > 0) {
		return 38572992;
	    }
	}
	return -385;
    }

    public static void main(String[] args) {
	System.out.println(new JLS_14_19_Synchronization_3().value(1));
	System.out.println(new JLS_14_19_Synchronization_3().value(-1));
    }
}