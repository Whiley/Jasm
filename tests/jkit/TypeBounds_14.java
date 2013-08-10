import java.util.ArrayList;

public class TypeBounds_14<E extends String> {
    public String x;
    public void f(ArrayList<E> y) {
	x = y.get(0);
	System.out.println("GOT: " + x);
    }

    public static void main(String[] args) {
	TypeBounds_14<String> x = new TypeBounds_14<String>();
	ArrayList<String> xs = new ArrayList<String>();
	xs.add("Hello");
	x.f(xs);	
    }
}
