public class JLS_15_13_ArrayAccess_1 {
    public static void main(String[] args) {
	int x = 0;
	int y = 0;
	int[][] xs = {{0},{0,1},{0,1,2}};
	xs[++y][y] = 99;
	xs[y][--y] = 101;
	for(int[] zs : xs){
	    for(int z : zs) {
		System.out.println(z);
	    }
	}
    }
}
