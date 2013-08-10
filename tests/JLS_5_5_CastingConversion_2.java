public class JLS_5_5_CastingConversion_2 {
    static interface I1 { }
    static interface I2 { }
    static class Inner implements I1,I2 {

    }

    public static void main(String[] args) {
	I1 x = new Inner();
	I2 y = (I2) x;
	System.out.println("OK");
    }
}
