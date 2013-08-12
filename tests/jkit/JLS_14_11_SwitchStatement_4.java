public class JLS_14_11_SwitchStatement_4 {
	
	private static final int LABEL1 = 0;
	private static final int LABEL2 = 1;
	private static final int LABEL3 = 2;
	
	
	public static void f(int x) {
		switch(x) {
		case LABEL1:
			System.out.println("LABEL1");
			break;
		case LABEL2:
			System.out.println("LABEL2");
			break;
		case LABEL3:
			System.out.println("LABEL3");
			break;
		}
	}
	
	public static void g(int x) {
		switch(x) {
		case CompiledCases.CCLABEL1:
			System.out.println("CCLABEL1");
			break;
		case CompiledCases.CCLABEL2:
			System.out.println("CCLABEL2");
			break;
		case CompiledCases.CCLAEBL3:
			System.out.println("CCLABEL3");
			break;
		}
	}
	
	public static void main(String[] args) {
		f(0);
		f(1);
		g(0);
		g(1);
	}

}
