import java.util.*;


public class JLS_8_4_4_GenericMethods_1 {
    public static abstract class Parent implements Iterator<String> {
    }
    
    public static final class Child extends Parent {
	public boolean hasNext() { return false; }
	public String next() { return null; }
    	public void remove() { }
    }
    
    public static void main(String args[]) {
	Parent x = new Child();
	x.next();
	System.out.println("GOT HERE");
    }
}
