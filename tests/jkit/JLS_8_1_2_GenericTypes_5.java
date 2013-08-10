import java.util.*;

public class JLS_8_1_2_GenericTypes_5 {
    public static Map<String,String> f() { return new HashMap(); }
    
    public static void main (String args[]) {
	Map<String,String> v3 = new HashMap();
	Map x = new HashMap<String,String>();
    }
}
