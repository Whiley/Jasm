import java.util.*;

public class JLS_14_9_IfStatement_7 {

    public static void f(String s) {
	syntax:
        {
            if (s == null)
                break syntax;
	    System.out.println("STAGE 1 - " + s);
	}
	System.out.println("STAGE 2");
    }

    public static void main(String[] args) {
	f("Hello");
	f(null);
    }
}