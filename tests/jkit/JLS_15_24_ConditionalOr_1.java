import java.util.*;

public class JLS_15_24_ConditionalOr_1 {
    public static void main(String[] args) {
	int pos = 0;
	String text = "\"HELLO \"WORLD";
	char c;
	pos++;
	boolean escaped=false;
	// escaped is needed so we don't terminate the string
	// prematurely
	while (pos < text.length()
	       && ((c = text.charAt(pos)) != '"' || escaped)) {
	    ++pos;	
	}
	System.out.println("GOT: " + pos);
    }
}
