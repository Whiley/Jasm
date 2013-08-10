public class JLS_9_3_ConstantFields_9 {
    public static final int intConstant1 = 123;
    public static final int intConstant2 = 32700;

    public static final byte[] byteArr = {
	1,2,3,4,5,intConstant1
    };

    public static final char[] charArr = {
	1,2,3,4,5,intConstant1
    };

    public static final short[] shortArr = {
	1,2,3,4,5,intConstant1,intConstant2
    };

    public static void main(String[] args) {
	for(byte b : byteArr) {
	    System.out.println(b);
	}

	for(char c : charArr) {
	    System.out.println(c);
	}

	for(short c : shortArr) {
	    System.out.println(c);
	}
    };
}
