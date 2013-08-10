import java.util.*;

public class JLS_8_1_2_GenericTypes_18 {

    public static void main(String[] args) {
	Map map = new HashMap();
	map.put("Hello","World");
	String x = (String) map.get("Hello");
	System.out.println(x);
    }
}
