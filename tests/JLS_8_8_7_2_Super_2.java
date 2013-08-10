public class JLS_8_8_7_2_Super_2 {    
    public JLS_8_8_7_2_Super_2(String name) {
	super();
	System.out.println("SUPER CONSTRUCTOR CALLED: " + name);
    }

    public static void main(String[] args) {
	new JLS_8_8_7_2_Super_2("Hello");
    }
}
