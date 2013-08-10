public class JLS_8_1_3_InnerClasses_3 {
    public JLS_8_1_3_InnerClasses_3() {
	Inner i = new Inner(1);
    }
    public class Inner {
	public Inner(int x) {
	    System.out.println("GOT " + x);
	}
    }    

    public static void main(String[] args) {	
	JLS_8_1_3_InnerClasses_3 i = new JLS_8_1_3_InnerClasses_3();
    }
}
