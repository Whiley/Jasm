public class JLS_15_20_2_InstanceofOperator_2 {
    public static void main(String[] args) {
	String[] arr1 = new String[0];
	if(arr1 instanceof Object[]) {
	    System.out.println("Instanceof ... OK");
	}
	if(arr1 instanceof Integer[]) {
	    System.out.println("Instanceof ... not OK");
	}
    }
}
