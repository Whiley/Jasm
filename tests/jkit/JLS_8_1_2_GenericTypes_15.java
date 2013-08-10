import java.util.*;

public class JLS_8_1_2_GenericTypes_15 implements Comparator<Integer> {
    public int compare(Integer i1, Integer i2) {
	return -1;
    }

    public boolean equals(Integer i1, Integer i2) {
	return false;
    }

    public static <T> void f(T key, Comparator<? super T> c) {
	int cmp = c.compare(key, key);
	System.out.println("GOT HERE");
    }

    public static void main(String[] args) {	
	f(1,new JLS_8_1_2_GenericTypes_15());
    }
}
