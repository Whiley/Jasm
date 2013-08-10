public class JLS_8_1_3_InnerClasses_1 {
    static class Inner {
	public Inner(int x) {
	    System.out.println("GOT " + x);
	}
    }
    
    public static void main(String[] args) {
	JLS_8_1_3_InnerClasses_1.Inner i = new JLS_8_1_3_InnerClasses_1.Inner(1);
    }
}
