public class JLS_15_7_EvaluationOrder_2 {
    public static void main(String[] args) {
	int a=0,b,c;
	
	// lot's of weird side effects stuff
	c = b = a + 1;
	System.out.println(c);
	c ^= b ^= c ^= 10;
	System.out.println(c);
	a = (c=(b+1))+2;
	System.out.println(a);
	a = (c=0)+2+c;
	System.out.println(a);
	a = c+2+(c=0);
	System.out.println(a);

	b = c = 1;
	a = b++ + ++c + b;
	System.out.println(a);
	b = c = 1;
	a = b + ++b;
	System.out.println(a);
	b = c = 1;
	a = c + c++ + c;
	System.out.println(a);
    }
}
