import java.util.*;


public class JLS_8_7_StaticInitializers_2 {
    
    public static int x = 2;
    public static int y = ++x;

    public static JLS_8_7_StaticInitializers_2 t = new JLS_8_7_StaticInitializers_2();

    public JLS_8_7_StaticInitializers_2() {
	w = w + 1;
	z = y * 2;
    }

    public static int w = 7;
    public static int z = 7;

    public static void main(String[] args) {
	System.out.println(x);
	System.out.println(y);
	System.out.println(w);
	System.out.println(z);
    }
}
