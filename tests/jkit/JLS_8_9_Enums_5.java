public class JLS_8_9_Enums_5 {

    public enum XY {
	X {
	    String aMethod() { return "World"; }		
	},
	    Y {
		String aMethod() { return "Hello"; }		
	    };
	    
	abstract String aMethod();
    };

    public static void main(String[] args) {
	XY x = XY.Y;
	System.out.println("GOT: " + x.aMethod());
	x = XY.X;
	System.out.println("GOT: " + x.aMethod());
    }
}