
import java.math.*;

public class JLS_8_8_7_1_ConstructorInvocations_1 {
    BigInteger x;

    public JLS_8_8_7_1_ConstructorInvocations_1(BigInteger x) {
	this.x = x;
    }

    public JLS_8_8_7_1_ConstructorInvocations_1(int x) {
	this(BigInteger.valueOf(x));
    }

    public String toString() {
	return x.toString();
    }

    public static void main(String[] args) {
	System.out.println(new JLS_8_8_7_1_ConstructorInvocations_1(123423));
    }
}
