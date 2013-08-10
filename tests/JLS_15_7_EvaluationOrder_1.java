public class JLS_15_7_EvaluationOrder_1 {
    public static void main(String[] args) {
	int x=10;
	int y=0;
	for(int i=++y ; i < x++; i=i+2) {
	    System.out.println(i);
	}
	x = 13;
	while(y < x++) {
	    System.out.println(y);
	    y = y + 2;
	}
	
	if(y++ < --x) {
	    System.out.println("TRUE");
	} else {
	    System.out.println("FALSE");
	}
    }
}
