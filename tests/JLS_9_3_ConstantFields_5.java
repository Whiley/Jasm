public class JLS_9_3_ConstantFields_5 {
    public interface Inter {
	int y = x+1;
	int x = 123987;
    }

    public static void main(String[] args) {
	System.out.println(Inter.x);
	System.out.println(Inter.y);
    }
}