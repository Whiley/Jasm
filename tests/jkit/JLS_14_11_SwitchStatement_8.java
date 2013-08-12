import java.awt.event.InputEvent;

public class JLS_14_11_SwitchStatement_8 {
    public static void main(String[] args) {
	int x = InputEvent.CTRL_MASK;

	switch(x) {
	case InputEvent.CTRL_MASK:
	    System.out.println("GOT HERE");
	}
    }
}