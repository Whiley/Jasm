public class JLS_9_3_ConstantFields_6 {
    public interface Inter {
	int x = JLS_9_3_ConstantFields_3.Inter.x;
	int y = JLS_9_3_ConstantFields_3.Inter.y+1;
    }

    public static void main(String[] args) {
	System.out.println(Inter.x);
	System.out.println(Inter.y);
    }
}