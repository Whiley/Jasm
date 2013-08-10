public class JLS_14_19_Synchronization_2 {
    int value() {
	synchronized(this) {
	    return 3857902;
	}
    }

    public static void main(String[] args) {
	System.out.println(new JLS_14_19_Synchronization_2().value());
    }
}