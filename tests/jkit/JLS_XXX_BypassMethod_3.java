import java.util.*;

public class JLS_XXX_BypassMethod_3 {
    
    public interface Inter<T extends Number> {
	void f(String x, T y);
	T g(String x, int y);
    }

    public static class Inner implements Inter<Integer> {
	public void f(String x, Integer y) {
	    System.out.println("GOT: " + x + " AND " + y);
	}

	public Integer g(String x, int y) {
	    return y;
	}
    }

    public static void main(String[] args) {
	Inter<Integer> i = new Inner();
	i.f("Hello",new Integer(1));
	System.out.println(i.g("Goodbye",1));
    }
}
