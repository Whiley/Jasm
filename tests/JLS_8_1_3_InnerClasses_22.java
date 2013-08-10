import java.util.*;

public class JLS_8_1_3_InnerClasses_22 {

    public static class Ent<K,V> extends AbstractMap<K,V> implements Map<K,V> {

	public Set<Map.Entry<K,V>> entrySet() {
	    return null;
	}

	Entry<K,V> get() {
	    return null;
	}
    }    

    public static class Entry<K,V>  {
	int value = 123987;
    }    


    public static void main(String[] args) {
	int x = new JLS_8_1_3_InnerClasses_22.Ent<String,String>().get().value;
	System.out.println("Look what I got: " + x);
    }
} 