import java.lang.reflect.*;
import java.util.*;

public class JLS_8_1_2_GenericTypes_13 {

    interface Inter<D extends JLS_8_1_2_GenericTypes_13> {    
	public D getGenericDeclaration();
    }

    public static class Concrete<D extends JLS_8_1_2_GenericTypes_13> implements Inter<D> { 
	public D getGenericDeclaration() {
	    System.out.println("GOT CALLED");
	    return null; 
	}
    }

    public static void main(String[] args) {
	Inter<JLS_8_1_2_GenericTypes_13> p = new Concrete<JLS_8_1_2_GenericTypes_13>();

	p.getGenericDeclaration();
    }
}