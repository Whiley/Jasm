public class JLS_9_3_ConstantFields_3 {
    public interface Inter {
	int x = 123987;
	int y = x;
    }

    public static void main(String[] args) {
	System.out.println(Inter.x);
	System.out.println(Inter.y);
    }
}