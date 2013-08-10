
import java.util.*;
import java.util.concurrent.*;

public class JLS_15_8_1_StringConcatenation_1 {
    public JLS_15_8_1_StringConcatenation_1[] arguments = new JLS_15_8_1_StringConcatenation_1[10];

    public String toString() {
	String r = "(";
	boolean firstTime = true;
	for(JLS_15_8_1_StringConcatenation_1 e : arguments) {
	    if(!firstTime) {
		r += ",";
	    }
	    firstTime=false;
	    r += e;
	}
	return r + ")";
	
    }
    

    public static void main(String[] args) {
	System.out.println(new JLS_15_8_1_StringConcatenation_1());
    }
}
