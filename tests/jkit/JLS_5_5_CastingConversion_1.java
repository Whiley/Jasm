import java.io.Serializable;

public class JLS_5_5_CastingConversion_1 {
    public static void main(String[] args) {
	Object x = new Integer(1);
	Object y = new Float(2.0);
	Cloneable z = new int[10];
	Serializable w = new int[10];

	try {
	    Integer a = (Integer) x;
	    System.out.println("Cast 1 ... OK");
	} catch(ClassCastException e) {
	    System.out.println("ClassCastException");
	    e.printStackTrace();
	}

	try {
	    Integer a = (Integer) y;	    
	} catch(ClassCastException e) {
	    System.out.println("Cast 2 ... OK");
	}

	try {
	    int[] a = (int[]) z;	    
	    System.out.println("Cast 3 ... OK");
	} catch(ClassCastException e) {
	    System.out.println("ClassCastException");
	    e.printStackTrace();
	}	

	try {
	    int[] a = (int[]) w;	    
	    System.out.println("Cast 4 ... OK");
	} catch(ClassCastException e) {
	    System.out.println("ClassCastException");
	    e.printStackTrace();
	}	
    }
}
