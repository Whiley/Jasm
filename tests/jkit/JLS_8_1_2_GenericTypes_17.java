import java.util.*;

public class JLS_8_1_2_GenericTypes_17 implements Comparator<String> {

    public int compare(String x, String y) {
	return 0;
    }
    
    public boolean equals(String x, String y) {
	return false;
    }

    public static <T> void f(List<? extends Comparable<? super T>> list, T key) {
	System.out.println("GOT HERE");
    }


    public static <T> void f(List<? extends T> list, T key, Comparator<? super T> c) {
	if(c != null)
	    f((List) list, key);
    }

    public static void main(String[] args) {
	f(new ArrayList<String>(),"Hello", new JLS_8_1_2_GenericTypes_17());
    }
}
