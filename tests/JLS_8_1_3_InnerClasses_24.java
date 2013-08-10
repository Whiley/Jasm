import java.util.*;

public class JLS_8_1_3_InnerClasses_24 {
    public JLS_8_1_3_InnerClasses_24(String x) {
	System.out.println("JLS_8_1_3_InnerClasses_24 called: " + x);
    }

    class Parent {
	public Parent(String x) {
	    System.out.println("JLS_8_1_3_InnerClasses_24.Parent called: " + x);
	}	
    }

    class Inner extends Parent {
	public Inner(String x) {
	    super(x);
	    System.out.println("JLS_8_1_3_InnerClasses_24.Inner called: " + x);
	}
    }
    
    public class Child extends Inner {
	public Child(String x) {	    
	    super(x);
	    System.out.println("JLS_8_1_3_InnerClasses_24.Child called: " + x);
	}
    }

    public static void main(String[] args) {
	JLS_8_1_3_InnerClasses_24 t = new JLS_8_1_3_InnerClasses_24("Hello");
	Child c = t.new Child("Hello");
    }
}