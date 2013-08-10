import java.util.*;


public class JLS_8_4_4_GenericMethods_2 {
    public static abstract class Parent<T> {
	abstract T next();
    }
    
    public static final class Child extends Parent<String> {
	public String next() { return null; }
    }
    
    public static void main(String args[]) {
	Parent x = new Child();
	x.next();
	System.out.println("GOT HERE");
    }
}
