public class JLS_8_1_3_InnerClasses_2 {
    public static class Inner {
	public void test(int x) {
	    System.out.println("GOT " + x);
	}
    }
    
    public static void main(String[] args) {
	JLS_8_1_3_InnerClasses_2.Inner i = new JLS_8_1_3_InnerClasses_2.Inner();
	
	i.test(1);
    }
}
