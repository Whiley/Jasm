public class JLS_14_14_ForStatement_1 {
    public static void main(String[] args) {
	int i;
	int acc = 0;
	int c1 = 9;
	int c2 = 13;

	for(i=0;i<10;++i) {
	    acc = acc + (c1 * c2);
	}
	if(acc == 1170) { System.out.println("Loop 1 ... OK"); }
	
	for(int j=0;j<10;++j) {
	    acc = acc + (c1 * c2);
	}
	if(acc == 2340) { System.out.println("Loop 2 ... OK"); }

	for(i=0,acc=0;i<10;++i) {
	    acc = acc + (c1 * c2);
	}
	if(acc == 1170) { System.out.println("Loop 3 ... OK"); }

	for(i=0,acc=0;i<10;++i,acc=acc*2) {
	    acc = acc + (c1 * c2);
	}
	if(acc == 239382) { System.out.println("Loop 4 ... OK"); }
    }
}
