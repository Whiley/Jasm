import java.util.*;

public class JLS_8_1_3_InnerClasses_21<K,V> extends AbstractMap<K,V> implements Map<K,V> {
    public Entry<K,V> f() {
	return new Entry();
    }

    public void g() {
	for (Entry<K,V> e = f(); e != null; e = e.next) {
	    System.out.println("GOT: " + e.value);
	}	    
    }

    public Set<Map.Entry<K,V>> entrySet() {
	return null;
    }

    public static class Entry<K,V> implements Map.Entry<K,V> {
	Entry<K,V> next = null;
	int value = 123987;

	public V setValue(V v) { return null; }
	public V getValue() { return null; }
	public K setKey(K v) { return null; }
	public K getKey() { return null; }
	    
    }    

    public static void main(String[] args) {
	new JLS_8_1_3_InnerClasses_21<String,String>().g();
    }
} 