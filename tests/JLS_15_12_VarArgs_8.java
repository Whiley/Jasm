import java.util.*;

public class JLS_15_12_VarArgs_8 {

    public static class Attribute {}

    private List<Attribute> attributes;

    public JLS_15_12_VarArgs_8() {		
    }
    
    public JLS_15_12_VarArgs_8(Attribute... attributes) {
	this.attributes = new ArrayList<Attribute>(Arrays.asList(attributes));			
    }

    public void add(Attribute... attributes) {
	this.attributes = new ArrayList<Attribute>(Arrays.asList(attributes));			
    }
    
    public Attribute attribute(Class c) {
	for(Attribute a : attributes) {
	    if(c.isInstance(a)) {
		return a;
	    }
	}
	return null;
    }		

    public static void main(String[] args) {
	JLS_15_12_VarArgs_8 t = new JLS_15_12_VarArgs_8();
	t.add(new Attribute());
	if(t.attribute(Attribute.class) != null) {
	    System.out.println("METHOD OK");
	}

	t = new JLS_15_12_VarArgs_8(new Attribute());
	if(t.attribute(Attribute.class) != null) {
	    System.out.println("CONSTRUCTOR OK");
	}
    }
}



