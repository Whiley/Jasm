import java.util.ArrayList;

public class TypeBounds_15<E extends String> {
    public String x;

    public void f(ArrayList<E> y) {
	System.out.println("Shouldn't get here!");
    }

    public static void main(String[] args) {
	TypeBounds_15<String> x = new TypeBounds_15<String>();
	ArrayList<Integer> xs = new ArrayList<Integer>();
	xs.add(1);
	xs.add(2);
	xs.add(3);
	x.f(xs);	
    }
}
