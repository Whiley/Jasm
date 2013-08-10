public class JLS_15_13_ArrayAccess_5 {
    public static void main(String[] args) {
	Integer is[] = {2,3,4,5,6,7};
	is[is[0]] = 0;	    
	for(Integer a : is) {
	    System.out.println(a);
	}
    }
} 