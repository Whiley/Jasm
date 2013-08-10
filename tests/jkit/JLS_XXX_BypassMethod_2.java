import java.util.*;

public class JLS_XXX_BypassMethod_2 {
    
    public interface Inter<T> {
	void f(String x, T y);
	T g(String x, int y);
    }

    public static class Inner implements Inter<String> {
	public void f(String x, String y) {
	    System.out.println("GOT: " + x + " AND " + y);
	}

	public String g(String x, int y) {
	    return x;
	}
    }

    public static void main(String[] args) {
	Inter<String> i = new Inner();
	i.f("Hello","World");
	System.out.println(i.g("Goodbye",1));
    }
}
