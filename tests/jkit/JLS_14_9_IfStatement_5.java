import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JLS_14_9_IfStatement_5 {	
    private static ImageIcon emptySquare = null;

    public static class GridSquare {}
    public static class EmptySquare extends GridSquare {}
    
    private ImageIcon getSquareIcon(GridSquare gs) {
    	if(gs instanceof EmptySquare) {
	    return emptySquare;
    	} else {
	    return emptySquare;
    	}
    }


    public static void main(String[] args) {
	ImageIcon img1 = new JLS_14_9_IfStatement_5().getSquareIcon(new EmptySquare());
	System.out.println(img1);
    }
}
