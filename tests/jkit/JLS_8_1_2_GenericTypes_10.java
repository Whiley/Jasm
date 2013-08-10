public class JLS_8_1_2_GenericTypes_10 {
    static <T> T trace(String reason) {
	System.out.println("Hello World");
	return null;
    }

    public static void main(String[] args) {
	String x = trace("Hello world");
    }
}