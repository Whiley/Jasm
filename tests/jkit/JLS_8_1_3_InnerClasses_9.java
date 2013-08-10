import java.util.*;

public class JLS_8_1_3_InnerClasses_9 {
    public static void g(String m) {
	System.out.println(m);
    }

    public static class Inner {
	public void f() {
	    g("Hello");
	}
    }

    public static void main(String[] args) {
	new JLS_8_1_3_InnerClasses_9.Inner().f();
    }
}
