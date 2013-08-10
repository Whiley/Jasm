import java.io.*;

class JLS_15_26_2_CompoundAssignmentOperators_1 { 
    public static void main(String[] args) {
	int x = 1984;
	int y = 2008;
	x ^= y ^= x ^= y;
	System.out.println("x = " + x + " y = " + y);

	x = 1984;
	y = 2008;
	y = (x ^= (y ^= x)) ^ y;
	System.out.println("x = " + x + " y = " + y);		
    }
} 
