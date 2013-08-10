public class JLS_8_9_Enums_6 {

    public enum XY {
	X,Y ;
	    
	String aMethod() { return "Hello World"; }
    };

    public static void main(String[] args) {
	XY x = XY.X;
	System.out.println("GOT: " + x.aMethod());
    }
}