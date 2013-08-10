public class JLS_15_25_ConditionalOperator_3<T> {
    private final T first;
    
    public JLS_15_25_ConditionalOperator_3(T f) {
	first=f;		
    }		
    public int hashCode() {
	int fhc = first == null ? 0 : first.hashCode();
	return fhc; 
    }

    public static void main(String[] args) {
	JLS_15_25_ConditionalOperator_3<String> qm2 = new JLS_15_25_ConditionalOperator_3("Hello World");
	System.out.println("HASHCODE: " + qm2.hashCode());
    }
}
