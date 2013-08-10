class JLS_8_4_4_GenericMethods_3<K,V>
{
    <T> T method1() {
	return null;
    }
  
    K method2() {
	return JLS_8_4_4_GenericMethods_3.<K>method1();
    }
    
    public static void main(String[] args) {
	JLS_8_4_4_GenericMethods_3<String,Integer> x = new JLS_8_4_4_GenericMethods_3<String,Integer>();
	System.out.println("GOT: " + x.method2());
    }
}
