public class JLS_8_8_7_2_Super_3 {    
    static class Sub_3 extends JLS_8_8_7_2_Super_3 {
	int field = 2;
	
	public int getField() {
	    return super.field;
	}
    }

    public int field = 1;

    public static void main(String[] args) {
	System.out.println(new Sub_3().getField());
    }
}
