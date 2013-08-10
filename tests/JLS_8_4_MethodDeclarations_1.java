public class JLS_8_4_MethodDeclarations_1 {
    public void m(JLS_8_4_MethodDeclarations_1 x) {
	System.out.println("first one");
    }
    public void m(JLS_8_4_MethodDeclarations_1 x) {
	System.out.println("second one");
    }
    public static void main(String[] args) {
	JLS_8_4_MethodDeclarations_1 t = new JLS_8_4_MethodDeclarations_1();
	m(t);
    }
} 