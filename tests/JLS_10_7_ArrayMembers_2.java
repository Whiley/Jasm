public class JLS_10_7_ArrayMembers_2 {
    public static void main (String args[]) {
	int[] xs = {1,2,3,4,5,6,7,8,9};
	int[] ys;
	
	ys = (int[]) xs.clone();
	// the following line is a problem!!
	ys = xs.clone();
	for(int y : ys) {
	    System.out.println(y + " ");
	}	
    }
}
