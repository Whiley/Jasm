public class JLS_15_9_5_AnonymousClasses_1 {
    public void test() { System.out.println("BROKEN"); }

    public static void main(String[] args) {
	JLS_15_9_5_AnonymousClasses_1 x = new JLS_15_9_5_AnonymousClasses_1() {
		public void test() { System.out.println("YEAH"); }
	    };
	x.test();
    }
}   

