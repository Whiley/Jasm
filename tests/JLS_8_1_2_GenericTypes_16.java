import java.util.*;

public class JLS_8_1_2_GenericTypes_16 {

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
	System.out.println("GOT HERE");
    }

    public static void main(String[] args) {
	sort(new ArrayList<String>());
    }
}
