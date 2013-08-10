public class JLS_XXX_BypassMethod_6 {
    public boolean remove(Object o) {
	return false;
    }

    public static class Inner<E> extends JLS_XXX_BypassMethod_6 {
	public E remove(int x) {
	    System.out.println("GOT: " + x);
	    return null;
	}
    }

    public static void main(String[] args) {
	new Inner<String>().remove(1);
    }
}