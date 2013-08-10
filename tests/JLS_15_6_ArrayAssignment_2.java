public class JLS_15_6_ArrayAssignment_2 {
    static char[][] charMap;

    public static void main(String[] args) {
	charMap =  new char[][] { {'a','b','c'} };
	System.out.println(charMap[0]);
    }
}