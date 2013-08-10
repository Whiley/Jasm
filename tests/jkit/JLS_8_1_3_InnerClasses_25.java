import java.util.*;

public class JLS_8_1_3_InnerClasses_25<E> {

    public JLS_8_1_3_InnerClasses_25(String x) {
	System.out.println("JLS_8_1_3_InnerClasses_25 called: " + x);
    }

    private class Itr implements Iterator<E> {
	/**
	 * Index of element to be returned by subsequent call to next.
	 */
	int cursor = 0;

	public boolean hasNext() {
            return cursor != 0;
	}

	public E next() {
	    return null;
	}

	public void remove() {
	}
    }

    private class ListItr extends Itr implements ListIterator<E> {
	ListItr(int index) {
	    System.out.println("LIST ITR CALLED");
	    cursor = index;
	}

	public boolean hasPrevious() {
	    return cursor != 0;
	}

        public E previous() {
	    return null;
        }

	public int nextIndex() {
	    return cursor;
	}

	public int previousIndex() {
	    return cursor-1;
	}

	public void set(E o) {
	}

	public void add(E o) {
	}
    }

    public static void main(String[] args) {
	JLS_8_1_3_InnerClasses_25 t = new JLS_8_1_3_InnerClasses_25("Hello");
	Iterator<String> c = t.new ListItr(1);
    }
}