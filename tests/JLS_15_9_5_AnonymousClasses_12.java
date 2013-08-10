import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JLS_15_9_5_AnonymousClasses_12 {

    public static void main(String args[]) {
	new JLS_15_9_5_AnonymousClasses_12() {
	    private int i = 10;
	    public void doSomething() {
		System.out.println(i);
	    }
	}.doSomething();
    }
} 