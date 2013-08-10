class JLS_4_3_2_GetClass_1 {
  public static void main (String args[]) {
      JLS_4_3_2_GetClass_1 x = new JLS_4_3_2_GetClass_1();
      String n = x.getClass().getName();
      if(n.equals("JLS_4_3_2_GetClass_1")) {
	  System.out.println("Reference OK");
      } else {
	  System.out.println("ERROR 1: " + n);
      } 

      int[] arr = new int[10];
      n = arr.getClass().getName();
      if(n.equals("[I")) {
	  System.out.println("Array OK");
      } else {
	  System.out.println("ERROR 2: " + n);
      }

      n = int.class.getName();
      if(n.equals("int")) {
	  System.out.println("Int OK");
      } else {
	  System.out.println("ERROR 3: " + n);
      }

      n = JLS_4_3_2_GetClass_1.class.getName();
      if(n.equals("JLS_4_3_2_GetClass_1")) {
	  System.out.println("JLS_4_3_2_GetClass_1 OK");
      } else {
	  System.out.println("ERROR 4: " + n);
      }
  }
}
