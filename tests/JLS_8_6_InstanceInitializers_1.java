public final class JLS_8_6_InstanceInitializers_1 { 
    public String x = "x was initialised";

    {
	int j = 0;
	System.out.println(j);
	System.out.println(x);
    }

    public static void main(String[] args) {
	new JLS_8_6_InstanceInitializers_1();
	System.out.println("Hello World!");
    }
} 
