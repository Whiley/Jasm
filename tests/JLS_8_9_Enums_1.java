import java.util.*;

public class JLS_8_9_Enums_1 {	    
    public enum Type {
	ONE,
	    TWO,
	    THREE
	    };
    
    public static Type get() { return Type.ONE; }

    public static void main(String[] args) {
	if(get() == JLS_8_9_Enums_1.Type.ONE) {
	    System.out.println("GOT ONE");
	} else if(get() == JLS_8_9_Enums_1.Type.TWO) {
	    System.out.println("GOT TWO");
	} else if(get() == JLS_8_9_Enums_1.Type.THREE) {
	    System.out.println("GOT THREE");
	}
    }
}

