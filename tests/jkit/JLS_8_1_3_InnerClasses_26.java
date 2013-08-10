import java.util.*;

public class JLS_8_1_3_InnerClasses_26<E> {

    public JLS_8_1_3_InnerClasses_26(String x) {
	System.out.println("JLS_8_1_3_InnerClasses_26 called: " + x);
    }

    private static class Itr implements Iterator<String> {
	/**
	 * Index of element to be returned by subsequent call to next.
	 */
	int cursor = 0;

	public boolean hasNext() {
            return cursor != 0;
	}

	public String next() {
	    return null;
	}

	public void remove() {
	}
    }

    private class ListItr extends Itr {
	ListItr(int index) {
	    System.out.println("LIST ITR CALLED");
	    cursor = index;
	}
    }

    public static void main(String[] args) {
	JLS_8_1_3_InnerClasses_26 t = new JLS_8_1_3_InnerClasses_26("Hello");
	Iterator<String> c = t.new ListItr(1);
    }
}