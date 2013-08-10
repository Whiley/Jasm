import java.util.*;

public class JLS_15_12_VarArgs_7 {
    public String[] arr;

    JLS_15_12_VarArgs_7(String... ss) {
	arr = ss;
    }
    
    public static JLS_15_12_VarArgs_7 f(String s1, String s2) {
	return new JLS_15_12_VarArgs_7(s1,s2);
    }

    public static void main(String[] args) {
	JLS_15_12_VarArgs_7 test = f("hello","world");
	for(String s : test.arr) {
	    System.out.println(s);
	}
    }
}
