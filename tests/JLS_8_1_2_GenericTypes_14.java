import java.util.*;

public class JLS_8_1_2_GenericTypes_14<T> {
    Iterator<T> f() {
        return new Iterator<T>() {
            public boolean hasNext() {
		System.out.println("HELLO WORLD");
                return false;
            }
	    
            public T next() {
                return null;
            }	    

	    public void remove() {

	    }
        };
    }

    public static void main(String[] args) {
	new JLS_8_1_2_GenericTypes_14<String>().f().hasNext();
    }
}
