public class JLS_15_13_ArrayAccess_2 {
    public static void main(String[] args) {
	int[] arr = new int[10];
	int i = 0;
	arr[i++ + i + ++i] = 1; // tasty!
	arr[++i + --i] = 2;     // yum!
	arr[++i]++;
	for(int a : arr) {
	    System.out.println(a);
	}
    }
}
