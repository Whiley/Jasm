public class JLS_14_20_TryStatement_2 {
    public static void main(String[] args) {
	int x = 0;

	for(int i=0;i!=10;++i) {
	    try {
		if(i == 5) { continue; }
	    } catch(Exception e) {

	    } finally {
		x = x + 1;
	    }
	}
	System.out.println(x);
	x=0;
	for(int i=0;i!=10;++i) {
	    try {
		if(i == 5) { break; }
	    } catch(Exception e) {

	    } finally {
		x = x + 1;
	    }
	}
	System.out.println(x);
    }
}
