import java.util.*;

public class JLS_8_1_3_InnerClasses_15 {
    public class Inner {
	public JLS_8_1_3_InnerClasses_15 _this = JLS_8_1_3_InnerClasses_15.this;
    }
    public static void main(final String[] args) {
	JLS_8_1_3_InnerClasses_15 x = new JLS_8_1_3_InnerClasses_15();
	JLS_8_1_3_InnerClasses_15.Inner xi = x.new Inner();
	if(xi._this == x) {
	    System.out.println("GOT IT");
	}
    }
}
