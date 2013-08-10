import java.util.*;

public class JLS_15_20_2_InstanceofOperator_3 {
    public static int invoke_label = 0;

    public void f(Object e) {
	if(e instanceof String) {
	    String ivk = (String) e;
	    String retLabel = "$" + invoke_label++;
	    System.out.println("GOT: " + retLabel);
	}
    }

    public static void main(String[] args) {
	new JLS_15_20_2_InstanceofOperator_3().f("Hello");
    }
}
