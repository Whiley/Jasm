import java.util.*;

public class JLS_9_3_ConstantFields_7 {
    public interface Inter {
	ArrayList<Integer> a = new ArrayList<Integer>(){{add(1);add(2);}};
	String[] arr = {"Hello","World"};
	String z = "Hello asdasd";
	int y = z.length();
    }

    public static void main(String[] args) {
	System.out.println(Inter.y);
	System.out.println(Arrays.toString(Inter.arr));
	System.out.println(Inter.a.size());
    }
}