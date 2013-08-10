
import java.util.*;
import java.util.concurrent.*;

public class JLS_8_1_2_GenericTypes_9 {
    List<String> attributes;
    
    public JLS_8_1_2_GenericTypes_9(String[] attributes) {
	this.attributes = new ArrayList<String>(Arrays.asList(attributes));			
    }	

    public static void main(String[] args) {
	String[] strs = new String[3];

	strs[0] = "Hello";
	strs[1] = " ";
	strs[2] = "World";

	JLS_8_1_2_GenericTypes_9 t = new JLS_8_1_2_GenericTypes_9(strs);

	System.out.println(t.attributes);
    }
}
