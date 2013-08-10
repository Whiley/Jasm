public class JLS_14_14_ForStatement_2 {
    public static void main(String[] args) {
	int x = 0;

	for(int i=0;i!=10;++i) {
	    if(i == 5) { continue; }
	    x = x + 1;
	}
	System.out.println(x);
	x=0;
	for(int i=0;i!=10;++i) {
	    if(i == 5) { break; }
	    x = x + 1;
	}
	System.out.println(x);
    }
}
