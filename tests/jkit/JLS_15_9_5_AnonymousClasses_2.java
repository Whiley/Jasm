public class JLS_15_9_5_AnonymousClasses_2 {
    public void test() { System.out.println("BROKEN"); }

    public JLS_15_9_5_AnonymousClasses_2 go() {
	JLS_15_9_5_AnonymousClasses_2 x = new JLS_15_9_5_AnonymousClasses_2() {
		public void test() { System.out.println("YEAH"); }
	    };
	return x;
    }

    public static void main(String[] args) {
	new JLS_15_9_5_AnonymousClasses_2().go().test();
    }
}   

