public class JLS_14_11_SwitchStatement_5 {
    public static void main(String[] args) {
	int x = 1;
	while(x != 0) {
	    switch((x=x-1)) {
	    case 0:
		x = 2;
		break;
	    case 1:
		x = 3;
		break;
	    case 2:
	    case 3:
	    case 4:
		x = 0;
	    }
	    System.out.println(x);
	}
    }
}
