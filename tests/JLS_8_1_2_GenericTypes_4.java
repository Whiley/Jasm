public class JLS_8_1_2_GenericTypes_4<T> {
    public JLS_8_1_2_GenericTypes_4(T f) {
	int x= f.hashCode();
	System.out.println("HASHCODE: " + x);
    }		

    public static void main(String[] args) {
	JLS_8_1_2_GenericTypes_4<String> g4 = new JLS_8_1_2_GenericTypes_4<String>("Hello World");
    }    
}
