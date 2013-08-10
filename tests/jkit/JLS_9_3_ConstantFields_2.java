public class JLS_9_3_ConstantFields_2 {	
    public static interface aInter {
	public final int aCONSTANT = 1246352;
    }
    public static interface bInter  {
	public final int bCONSTANT = 987352;
    }

    public static interface Inter extends aInter, bInter {
    }

    public static class Inner extends JLS_9_3_ConstantFields_2 implements Inter {
    }

    public static void main(String[] args) {
	Inner i = new Inner();
	System.out.println(i.aCONSTANT);
	System.out.println(i.bCONSTANT);
    }
}
