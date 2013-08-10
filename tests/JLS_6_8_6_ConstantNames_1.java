interface A {
    int one = 1;
}

class B implements A {
    {
	System.out.println("GOT HERE");
    }
}

public class JLS_6_8_6_ConstantNames_1 {
    public static void main(String[] args) {	
	A a = new B();
    }
}
