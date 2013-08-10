public class JLS_8_1_3_InnerClasses_5 {
	
	public static class A {
		protected Integer i = new Integer(1);
	}
	
	public static class B extends A {
		
		class C {
			public Integer f() {
				return i;
			}
		}
	}
	
	public static void main(String[] args) {
		B b = new B();
		B.C c = b.new C();
		System.out.println("WANTED: " + 1);
		System.out.println("GOT: " + c.f());
	}


}
