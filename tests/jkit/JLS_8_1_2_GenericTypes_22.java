import java.util.*;

public class JLS_8_1_2_GenericTypes_22<T extends String> {
    public T f(List<?> e) {
	return (T) e.get(0);
    }

    public static void main(String[] args) {
	ArrayList<String> a = new ArrayList<String>();
	a.add("Hello Big World");
	System.out.println(new JLS_8_1_2_GenericTypes_22<String>().f(a));
    }
}