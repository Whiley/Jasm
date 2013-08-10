public class JLS_15_20_2_InstanceofOperator_1 {
    static interface Interface_1 {}
    static interface Interface_2 {}
    static class Instance_1 implements Interface_1,Interface_2 { }

    public static void main(String[] args) {
	Interface_1 i = new Instance_1();
	if(i instanceof Interface_2) {
	    System.out.println("Instanceof ... OK");
	}
    }
}
