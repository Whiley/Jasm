import java.util.ArrayList;

public class TypeBounds_4 {
    public String x;
    public void f(ArrayList<? extends String> y) {
	x = y.get(0);
	System.out.println("GOT: " + x);
    }

    public static void main(String[] args) {
	TypeBounds_4 x = new TypeBounds_4();
	ArrayList<String> xs = new ArrayList<String>();
	xs.add("Hello");
	x.f(xs);	
    }
}
