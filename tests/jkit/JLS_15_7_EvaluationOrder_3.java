public class JLS_15_7_EvaluationOrder_3 {
    public int f1 = 0;

    public JLS_15_7_EvaluationOrder_3(int f) {
	f1 = f;
    }

    public JLS_15_7_EvaluationOrder_3(int x, int y, int z) {
	f(x,y,z);
    }

    public static void f(int x, int y, int z) {
	System.out.println(x + ", " + y + ", " + z);
    }

    public static void main(String[] args) {
 	// this is basically another list of crazy side-effects.
	int[] a1 = {-5,-4,-3,-2,-1,01,2,3,4,5,6,7,8,9};
	int[] a2 = {10,20,30};
	int[] a3 = a1;

	// Array Index

	int a = (a3 = a2)[1];
	System.out.println(a);

	a = a1[(a1 = a3)[0]];
	System.out.println(a);

	int i = 0;
	a1[i] = (i=2) + 1;
	System.out.println(a1[0]);

	// Field Dereference

	JLS_15_7_EvaluationOrder_3 s1 = new JLS_15_7_EvaluationOrder_3(10);
	JLS_15_7_EvaluationOrder_3 s2 = new JLS_15_7_EvaluationOrder_3(100);
	JLS_15_7_EvaluationOrder_3 s3 = s1;
	
	(s3 = s2).f1 = s2.f1 + 1;
	System.out.println(s2.f1);

	s3 = s1;
	s1.f1 = (s1=s2).f1;
	s2.f1++;
	System.out.println(s3.f1);	

	// Method Invocation

	f(i,(i=26),++i);

	// New Invocation

	i = -1;
	new JLS_15_7_EvaluationOrder_3(i,(i=87),--i);

	// Ternary Operator

	int x = 1;
	int y = 2;

	x += args.length == 0 ? (x = 2*y) : y-1; 
	System.out.println(x + ", " + y);

	// other assignment operators
	i = 0;
	a1[i] ^= a1[(i = 2)];
	System.out.println(a1[0]);

	i = 0;
	a1[i] &= a1[(i = 2)];
	System.out.println(a1[0]);

	i = 0;
	a1[i] += a1[(i = 2)];
	System.out.println(a1[0]);

	i = 0;
	a1[i] -= a1[(i = 2)];
	System.out.println(a1[0]);

	s1 = new JLS_15_7_EvaluationOrder_3(10);
	s2 = new JLS_15_7_EvaluationOrder_3(100);
	s3 = s1;
	
	s1.f1 ^= (s1=s2).f1;
	System.out.println(s3.f1);
	s1 = s3;

	s1.f1 |= (s1=s2).f1;
	System.out.println(s3.f1);
	s1 = s3;

	s1.f1 *= (s1=s2).f1;
	System.out.println(s3.f1);
	s1 = s3;

	s1.f1 /= (s1=s2).f1;
	System.out.println(s3.f1);
	s1 = s3;	
    }
}
