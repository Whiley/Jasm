import java.util.*;

public class TypeBounds_13<E> {
    public boolean add(E o) {
	System.out.println("GOT: " + o);
	return false;
    }

    public void addAll(Collection<? extends E> c) {
	Iterator<? extends E> e = c.iterator();
	while (e.hasNext()) {
	    add(e.next());
	}
    }

    public static void main(String[] args) {
	TypeBounds_13<String> tb = new TypeBounds_13<String>();
	ArrayList<String> xs = new ArrayList<String>();
	xs.add("Hello");
	xs.add(" ");
	xs.add("World");
	tb.addAll(xs);
    }
}
