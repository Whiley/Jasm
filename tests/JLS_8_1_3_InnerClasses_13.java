import java.util.*;

public class JLS_8_1_3_InnerClasses_13 {
    public void f() {
	class Test2 {
	    public Test2() {
		System.out.println("Constructor");
	    }
	    public void f() { 
		System.out.println("Hello World");
	    }
	}
	new Test2().f();
    }
    public static void main(final String[] args) {
	new JLS_8_1_3_InnerClasses_13().f();	
    }
}
