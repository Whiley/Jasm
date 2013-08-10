public class JLS_15_14_PostfixOperators_2 {
    public JLS_15_14_PostfixOperators_2(int x, int y, int z) {
	System.out.println(x);
	System.out.println(y);
	System.out.println(z);
    }
    public static void main(String[] args) {
	int x = 1;
	int y = 3;
	int[] z = {x,2,x=3,++y,x=5};

	for(int i : z) {
	    System.out.println(i);
	}

	new JLS_15_14_PostfixOperators_2(x,x++,++x);
	new JLS_15_14_PostfixOperators_2(x,++x,x++);
    }
}
