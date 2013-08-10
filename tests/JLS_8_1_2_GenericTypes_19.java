import java.util.*;

public class JLS_8_1_2_GenericTypes_19 {

    public static void main(String[] args) {
	String[] arr = {"Hello","World"};
	Map map = new HashMap();
	map.put("Hello",arr);
	String[] x = (String[]) map.get("Hello");
	System.out.println(Arrays.toString(x));
    }
}
