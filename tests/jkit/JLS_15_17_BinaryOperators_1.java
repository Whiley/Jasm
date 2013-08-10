public class JLS_15_17_BinaryOperators_1 {
    public static void main(String args[]) {
	System.out.println("=== LONG SHIFTING ===");

        long l1 = 274638283649L;
	
	for(int i=0;i!=32;++i) {
	    System.out.println(l1 << i);
	    System.out.println(l1 >> i);
	    System.out.println(l1 >>> i);
	}

	System.out.println("=== INT SHIFTING ===");

	int i1 = 123456;
	
	for(int i=0;i!=32;++i) {
	    System.out.println(i1 << i);
	    System.out.println(i1 >> i);
	    System.out.println(i1 >>> i);
	}

	System.out.println("=== SHORT SHIFTING ===");

	short s1 = 22333;
	
	for(int i=0;i!=16;++i) {
	    System.out.println(s1 << i);
	    System.out.println(s1 >> i);
	    System.out.println(s1 >>> i);
	}

	System.out.println("=== CHAR SHIFTING ===");

	char c1 = 123;
	
	for(int i=0;i!=8;++i) {
	    System.out.println(c1 << i);
	    System.out.println(c1 >> i);
	    System.out.println(c1 >>> i);
	}

	System.out.println("=== BYTE SHIFTING ===");

	byte b1 = 123;
	
	for(int i=0;i!=8;++i) {
	    System.out.println(b1 << i);
	    System.out.println(b1 >> i);
	    System.out.println(b1 >>> i);
	}

	b1 = 4;
	System.out.println(i1 << b1);
    }
}
