import java.util.*;

public class JLS_XXX_BypassMethod_5 {
    public static interface Inter {
	public Iterable f();
    }

    public static class Child implements Inter {
	public Iterable<String> f() {
	    ArrayList<String> a = new ArrayList<String>();
	    a.add("Hello");
	    a.add("World");
	    return a;
	}
    }

    public static void main(String[] args) {
	JLS_XXX_BypassMethod_5.Child tc = new JLS_XXX_BypassMethod_5.Child();
	JLS_XXX_BypassMethod_5.Inter ti = tc;

	for(String s : tc.f()) {
	    System.out.println(s);
	}

	for(Object o : ti.f()) {
	    System.out.println(o);
	}
    }
}
