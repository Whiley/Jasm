public class JLS_8_1_3_InnerClasses_27 {
    private int size = 0x8ad7;

    public JLS_8_1_3_InnerClasses_27 f(){
	return new JLS_8_1_3_InnerClasses_27() {
	    public JLS_8_1_3_InnerClasses_27 f() {
		System.out.println("Got: " + --size);
		System.out.println("Got: " + ++size);
		System.out.println("Got: " + size--);
		System.out.println("Got: " + size++);
		return null;
	    }
	};
    }

    public static void main(String[] args) {
	new JLS_8_1_3_InnerClasses_27().f().f();
    }
}