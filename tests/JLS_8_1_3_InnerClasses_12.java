import java.util.*;

public class JLS_8_1_3_InnerClasses_12 {
    public static void main(final String[] args) {
	{
	    class Test2 {
		public Test2() {
		    System.out.println("Constructor");
		}
		public void f() { 
		    System.out.println("Hello World");
		}
	    }
	}
	new Test2().f();
    }
}
