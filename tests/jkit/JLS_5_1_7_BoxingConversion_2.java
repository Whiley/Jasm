public class JLS_5_1_7_BoxingConversion_2 {
	public static void main(String[] args) {
		Object[] a = { 1 };	
		Object[] b = { (Object) 2 };
		System.out.println(a[0] + " + " + b[0] + " = " + (((Integer)a[0])+((Integer)b[0])));
	}
}
