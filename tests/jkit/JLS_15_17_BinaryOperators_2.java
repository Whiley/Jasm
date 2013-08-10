public class JLS_15_17_BinaryOperators_2 {
	
	public static void main(String[] args) {
		
		int a = 2;
		int b = 6;
		int c = 3;
		
		int res = a * b / c;
		
		System.out.println("Wanted: " + 4);
		System.out.println("Got: " + res);
	}

}
