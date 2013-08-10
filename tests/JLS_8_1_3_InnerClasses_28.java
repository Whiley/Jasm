public class JLS_8_1_3_InnerClasses_28 {

    public void foo() {
	System.out.println("baz");
    }

    static class A {
	public void foo() {
	    System.out.println("foo");
	}
    }
    
    static class B {
	public void foo() {
	    System.out.println("bar");
	}
    }

    public static class C extends A {
	public void test() {
	    new B() {
		{
		    super.foo();
		    C.this.foo();
		    C.super.foo();
		}
	    };
	}
    }   
    
    public static void main(String args[]) {
	new C().test();
    }    
}