import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JLS_15_9_5_AnonymousClasses_10 {
    public static void main(String args[]) {
	// fix now makes it same as test23 in runtime errors
	System.out.println(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		}

		public String toString() { return "Hello World"; }
	    });
    }
} 
