import java.util.*;

public class JLS_8_1_3_InnerClasses_11 {

    public static void main(final String[] args) {
	class Test2 {
	    public void f() { 
		System.out.println("Hello World");
		for(String s : args) {
		    System.out.println(s);
		}
	    }
	}
	new Test2().f();
    }
}
