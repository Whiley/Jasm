public class JLS_15_26_2_CompoundAssignmentOperators_2 {
    public static void main(String[] args) {
	int y = 1234578;
	short x = 3279;

	x += y;
	System.out.println("GOT " + x);


	x -= y;
	System.out.println("GOT " + x);

	x *= y;
	System.out.println("GOT " + x);

	x /= y;
	System.out.println("GOT " + x);

	x %= y;
	System.out.println("GOT " + x);

	byte z = 32;

	z += y;
	System.out.println("GOT " + z);


	z -= y;
	System.out.println("GOT " + z);

	z *= y;
	System.out.println("GOT " + z);

	z /= y;
	System.out.println("GOT " + z);

	long w = 12398717;
	
	x += w;
	System.out.println("GOT " + x);

	x -= w;
	System.out.println("GOT " + x);

	x *= w;
	System.out.println("GOT " + x);

	x /= w;
	System.out.println("GOT " + x);

	x %= w;
	System.out.println("GOT " + x);

	z += w;
	System.out.println("GOT " + z);

	z -= w;
	System.out.println("GOT " + z);

	z *= w;
	System.out.println("GOT " + z);

	z /= w;
	System.out.println("GOT " + z);


    }
}