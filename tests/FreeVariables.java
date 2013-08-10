public class FreeVariables {
	
	public static void f() {
		Class<Integer> clz = Integer.class;
		g(clz);
	}
	
	public static void g(Class<?> clz) {
		System.out.println("Method g correct called");
	}
	
	public static void h() {
		i(new Integer(1)); // SHOULD COMPILE
		i("Test"); // SHOULDN'T COMPILE
	}
	
	public static <T extends Number> void i(T x) {
		System.out.println("Method i correctly called");
	}
	
	public static void main(String[] args) {
		f();
		h();
	}

}
