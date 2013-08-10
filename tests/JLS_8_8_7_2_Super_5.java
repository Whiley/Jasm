public class JLS_8_8_7_2_Super_5 {
    public static class Parent {
	public void method() {
	    System.out.println("Parent.method() called");
	}
    }

    public static class Child extends Parent {
	public void method() {
	    Child.super.method();
	    System.out.println("Child.method() called");
	}
    }
    
    public static void main(String[] args) {
	new Child().method();
    }
}
