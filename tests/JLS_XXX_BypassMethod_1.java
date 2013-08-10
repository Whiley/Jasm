import java.util.*;

public class JLS_XXX_BypassMethod_1 implements Iterator<String> {
    public boolean hasNext() { return true; }    
    public String next() { System.out.println("GOT HERE"); return null; }    
    public void remove() {}

    public static void main(String[] args) {
	Iterator<String> i = new JLS_XXX_BypassMethod_1();	
	i.next();
    }
}
