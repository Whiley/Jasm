public class JLS_14_19_Synchronization_1 {
    public void f() {
	synchronized(this) {
	    System.out.println("GOT HERE");
	}
    }
    public static void main(String[] args) {
	new JLS_14_19_Synchronization_1().f();
    }
}