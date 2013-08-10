public class JLS_15_11_FieldAccess_1 {
    static String fileName = "Hello";
    static String origFileName = "World";    

    public static void main(String[] args) {
	// following file is a problem.
	JLS_15_11_FieldAccess_1.fileName = JLS_15_11_FieldAccess_1.origFileName = "Hello World";	

	System.out.println(fileName);
    }
}