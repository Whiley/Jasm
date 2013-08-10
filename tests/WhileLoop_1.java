public class WhileLoop_1 {
    public static void main(String[] args) {
	int y = 10;
	int i = 0;
       
	while(i<(--y)) {
	    System.out.println("GOT: " + i);
	    i=i+1;
	}

	i = 0;
	y = 10;

	while(i++<(--y)); // yuk!
	System.out.println("GOT: " + i);
    }
}
