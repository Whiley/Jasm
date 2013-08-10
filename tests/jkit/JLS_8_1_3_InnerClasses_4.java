public class JLS_8_1_3_InnerClasses_4 {
	
	public static void main(String[] args) {
		InnerClassHelper.Helper1<Integer> helper = 
			new InnerClassHelper.Helper1<Integer>(new Integer(1));
		
		System.out.println("WANTED: " + 1);
		System.out.println("GOT: " + helper.get());
		
	}

}
