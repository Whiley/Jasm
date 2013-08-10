import java.util.Random;

public class NumberGenerator {

    public static String generateRandomByte(int idx, Random r) {
	byte[] edgeCases = { Byte.MIN_VALUE, Byte.MAX_VALUE, 0};
	byte b = idx < edgeCases.length ? edgeCases[idx] : (byte) r.nextInt();
	return Byte.toString(b);
    }

    public static String generateRandomChar(int idx, Random r) {
	char[] edgeCases = { Character.MIN_VALUE, Character.MAX_VALUE, 'a','b','c','d','e','f','g','h','j','k','l','A','B','C','D','E','F','G','H','J','I','0','1','2','3','4','5','6','7','8','%'};
	char c = idx < edgeCases.length ? edgeCases[idx] : (char) r.nextInt();
	return "0x" + Integer.toHexString(c);
    }

    public static String generateRandomShort(int idx, Random r) {
	short[] edgeCases = { Short.MIN_VALUE, Short.MAX_VALUE, 0};
        short s = idx < edgeCases.length ? edgeCases[idx] : (short) r.nextInt();
	return Short.toString(s);
    }

    public static String generateRandomInt(int idx, Random r) {
	int[] edgeCases = { Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
	int i = idx < edgeCases.length ? edgeCases[idx] : r.nextInt();
	return Integer.toString(i);
    }

    public static String generateRandomLong(int idx, Random r) {
	long[] edgeCases = { Long.MIN_VALUE, Long.MAX_VALUE, 0};
	long l = idx < edgeCases.length ? edgeCases[idx] : (long) r.nextLong();
	return Long.toString(l) + "L";
    }

    public static String generateRandomFloat(int idx, Random r) {
	String[] edgeCases = { "Float.MIN_VALUE", "Float.MAX_VALUE", "Float.NaN", "Float.NEGATIVE_INFINITY", "Float.POSITIVE_INFINITY" };
	if(idx < edgeCases.length) { return edgeCases[idx]; }
	return Float.toString(r.nextFloat()) + "F";
    }

    public static String generateRandomDouble(int idx, Random r) {
	String[] edgeCases = { "Double.MIN_VALUE", "Double.MAX_VALUE", "Double.NaN", "Double.NEGATIVE_INFINITY", "Double.POSITIVE_INFINITY" };
	if(idx < edgeCases.length) { return edgeCases[idx]; }
	return Double.toString(r.nextDouble());
    }


    public static String generateRandomValue(int idx, String type, Random r) {
	Number n;
	
	if(type.equals("byte")) {
	    return generateRandomByte(idx, r);
	} else if(type.equals("char")) {
	    return generateRandomChar(idx, r);
	} else if(type.equals("short")) {
	    return generateRandomShort(idx, r);
	} else if(type.equals("int")) {
	    return generateRandomInt(idx, r);
	} else if(type.equals("long")) {
	    return generateRandomLong(idx, r);
	} else if(type.equals("float")) {
	    return generateRandomFloat(idx, r);
	} else if(type.equals("double")) {
	    return generateRandomDouble(idx, r);
	}
	return null;
    }

    public static void main(String[] args) {
	int n = 100;
	
	if(args.length == 1) { n = Integer.parseInt(args[0]); }
	
	System.err.println("Generating " + n + " input cases.");

	Random r = new Random();

	String[] types = { "byte", "short", "char", "int", "long", "float", "double" };
	
	for(String type : types) {
	    System.out.print(type + "[] " + type.charAt(0) + "s = {");
	    
	    for(int i=0;i!=n;++i) {
		String v = generateRandomValue(i,type, r);
		if(i != 0) { System.out.print(","); }
		System.out.print(v);
	    }			    
	    
	    System.out.println("};\n\nfor(" + type + " v : " + type.charAt(0) + "s) {\n}");
	}
    }
}