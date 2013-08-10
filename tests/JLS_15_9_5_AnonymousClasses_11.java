import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JLS_15_9_5_AnonymousClasses_11 {
    String s = "HELLO WORLD";

    public static void main (String args[]) {
	new JLS_15_9_5_AnonymousClasses_11();
    }

    public JLS_15_9_5_AnonymousClasses_11(){
	new ActionListener(){
	    public void actionPerformed(ActionEvent e){
		new Thread(new Runnable(){
			public void run(){
			    System.out.println(s);
			    s = null;
			}
		    }).start();

		while(s != null) {
		    // busy wait ... yeah, ugly I know.
		}

		System.out.println("FINISHED");
	    }
	}.actionPerformed(null);
    }  
} 