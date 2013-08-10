public class JLS_15_25_ConditionalOperator_2 {    
    public static void main(String[] args) {
	int[] xs = { 10,23,45,33,66,77,11,868,0,-1 } ;
	int[] ys = { 40,23,11,-1,67,76,11,1023,-1,0 } ;

	int acc = 0;
	for(int i=0;i!=10;++i) {
	    acc += xs[i] < ys[i] ? xs[i] : 0;
	}
	if(acc == 943) {
	    System.out.println("Less than ... OK");
	} else {
	    System.out.println("Less than ... NOT OK (" + acc + ")");
	}

	acc = 0;
	for(int i=0;i!=10;++i) {
	    acc += xs[i] <= ys[i] ? xs[i] : 0;
	}
	if(acc == 977) {
	    System.out.println("Less than equal ... OK");
	} else {
	    System.out.println("Less than equal ... NOT OK (" + acc + ")");
	}

	acc = 0;
	for(int i=0;i!=10;++i) {
	    acc += xs[i] > ys[i] ? xs[i] : 0;
	}
	if(acc == 155) {
	    System.out.println("Greater than ... OK");
	} else {
	    System.out.println("Greater than ... NOT OK (" + acc + ")");
	}

	acc = 0;
	for(int i=0;i!=10;++i) {
	    acc += xs[i] >= ys[i] ? xs[i] : 0;
	}
	if(acc == 189) {
	    System.out.println("Greater than equal ... OK");
	} else {
	    System.out.println("Greater than equal ... NOT OK (" + acc + ")");
	}

	acc = 0;
	for(int i=0;i!=10;++i) {
	    acc += xs[i] != ys[i] ? xs[i] : 0;
	}
	if(acc == 1098) {
	    System.out.println("Not equal ... OK");
	} else {
	    System.out.println("Not equal ... NOT OK (" + acc + ")");
	}

	acc = 0;
	for(int i=0;i!=10;++i) {
	    acc += xs[i] == ys[i] ? xs[i] : 0;
	}
	if(acc == 34) {
	    System.out.println("Equal equal ... OK");
	} else {
	    System.out.println("Equal equal ... NOT OK (" + acc + ")");
	}

	acc = 0;
	for(int i=0;i!=10;++i) {
	    acc += (xs[i] & ys[i]) == 0 ? xs[i] : 0;
	}
	if(acc == -1) {
	    System.out.println("And ... OK");
	} else {
	    System.out.println("And ... NOT OK (" + acc + ")");
	}

	acc = 0;
	for(int i=0;i!=10;++i) {
	    acc += (xs[i] | ys[i]) == 0 ? xs[i] : 0;
	}
	if(acc == 0) {
	    System.out.println("Or ... OK");
	}  else {
	    System.out.println("Or ... NOT OK (" + acc + ")");
	}

	acc = 0;
	for(int i=0;i!=10;++i) {
	    acc += (xs[i] ^ ys[i]) == 0 ? xs[i] : 0;
	}
	if(acc == 34) {
	    System.out.println("Xor ... OK");
	}  else {
	    System.out.println("Xor ... NOT OK (" + acc + ")");
	}
    }
}
