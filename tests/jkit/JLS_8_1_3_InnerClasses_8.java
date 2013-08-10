import java.util.*;

public class JLS_8_1_3_InnerClasses_8 {
    public void g(String m) {
	System.out.println(m);
    }

    public class Inner {
	public void f() {
	    g("Hello");
	}
    }

    public Inner getInner() { return new Inner(); }

    public static void main(String[] args) {
	new JLS_8_1_3_InnerClasses_8().getInner().f();
    }
}
