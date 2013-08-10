public class JLS_8_1_3_InnerClasses_23 {
    public interface Inter {
	public void print();
    }

    static abstract class Parent implements Inter {
	public void f() {
	    print();
	}
    }

    static class Child extends Parent {
	public void print() {
	    System.out.println("Child.print() called");
	}
    }

    public static void main(String[] args) {
	new Child().f();
    }
}
