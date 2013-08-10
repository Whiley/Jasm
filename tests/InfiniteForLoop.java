public class InfiniteForLoop {
	
	public static void main(String[] args) {
		int i = 0;
		for(;;) {
			if(i == 100) {
				break;
			}
			i++;
		}
		System.out.println("FOR LOOP ENDED: " + i);
	}

}
