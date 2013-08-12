public class JLS_14_11_SwitchStatement_9 {
    public static void main(String[] args) {
	switch(args.length) {
	case 0:
	    System.out.println("Hello World");
	    String[] _args = {"hello"};
	    main(_args);
	    break;
	case 1:
	    if(args[0].equals("hello")) {
		System.out.println("And to you!");
		break;
	    }
	    break;
	}
    }
}
