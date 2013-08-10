public class JLS_15_13_ArrayAccess_6 {
    public void f(String[] args) {
	for(String s : args) {
	    System.out.println(s);
	}
    }

    public static void main(String[] args) {
	String[] xs = {"Hello","World","Goodbye"};
	new JLS_15_13_ArrayAccess_6().f(xs);	
    }
}
