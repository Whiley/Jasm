public class JLS_8_1_3_InnerClasses_16 {
   public class Inner {
       public String toString() { return "";}
   }
   public static void main(String[] args) {
       JLS_8_1_3_InnerClasses_16 t = null;
       Inner i = t.new Inner();
       System.out.println(i.toString());
   }
} 
