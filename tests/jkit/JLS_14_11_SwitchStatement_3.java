public class JLS_14_11_SwitchStatement_3 {
    
    public static void main(String args[]) {
	
	int[] ta = {1,3,5,7,0,2,4,6,8};
	int result = 0;	
	for (int i=0; i<ta.length; i++) {
	    switch (ta[i]) {
	    case 1  :
		if (i!= 9) result = result + i;
		break;
	    case 2  :
		if (i!= 8) result = result + i;
		break;
	    case 3  :
		if (i!= 7) result = result + i;
		break;
	    case 4  :
		if (i!= 6) result = result + i;
		break;
	    case 5  :
		if (i!= 5) result = result + i;
		break;
	    case 6  :
		if (i!= 4) result = result + i;
		break;
	    case 7  :
		if (i!= 3) result = result + i;
		break;
	    case 8  :
		if (i!= 2) result = result + i;
		break;
	    case 9  :
		if (i!= 1) result = result + i;
		break;
	    case 10  :
		if (i!= 0) result = result + i;
		break;
	    }
        }
	for (int i=0; i<ta.length; i++) {
	    switch (ta[i]) {
	    case 1  :
		if (i!= 9) result = result + i;
		break;
	    case 2  :
		if (i!= 8) result = result + i;
		break;
	    case 3  :
		if (i!= 7) result = result + i;
		break;
	    case 4  :
		if (i!= 6) result = result + i;
		break;
	    case 5  :
		if (i!= 5) result = result + i;
		break;
	    case 6  :
		if (i!= 4) result = result + i;
		break;
	    case 7  :
		if (i!= 3) result = result + i;
		break;
	    case 8  :
		if (i!= 2) result = result + i;
		break;
	    case 9  :
		if (i!= 1) result = result + i;
		break;
	    case 10  :
		if (i!= 0) result = result + i;
		break;
	    }
        }
	for (int i=0; i<ta.length; i++) {
	    switch (ta[i]) {
	    case 1  :
		if (i!= 9) result = result + i;
		break;
	    case 2  :
		if (i!= 8) result = result + i;
		break;
	    case 3  :
		if (i!= 7) result = result + i;
		break;
	    case 4  :
		if (i!= 6) result = result + i;
		break;
	    case 5  :
		if (i!= 5) result = result + i;
		break;
	    case 6  :
		if (i!= 4) result = result + i;
		break;
	    case 7  :
		if (i!= 3) result = result + i;
		break;
	    case 8  :
		if (i!= 2) result = result + i;
		break;
	    case 9  :
		if (i!= 1) result = result + i;
		break;
	    case 10  :
		if (i!= 0) result = result + i;
		break;
	    }
        }
	System.out.println("GOT: " + result);
    }
}
