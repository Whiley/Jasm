import java.util.*;

public class JLS_8_1_2_GenericTypes_20 {

    public static <T extends Object & Comparable<? super T>> void f(Collection<? extends T> coll) {
	Iterator<? extends T> i = coll.iterator();
	T candidate = i.next();

	if (candidate.compareTo(candidate) == 0)
	    System.out.println(candidate + " == " + candidate);
    }


    public static void main(String[] args) {
	ArrayList<String> ss = new ArrayList();
	ss.add("Hello");
	ss.add("Cruel");
	ss.add("World");
	f(ss);
	System.out.println(ss);
    }
}
