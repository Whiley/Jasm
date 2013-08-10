public class JLS_15_6_ArrayAssignment_3 {
 static int[] a = new int[2];
 public static void main(String[] args) {
   a[a[1]=1] += 1;
   System.out.println(a[1]);
   a[1] = 0;
   a[a[1]=1] = a[1] + 1;
   System.out.println(a[1]);
 }
} 