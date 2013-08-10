import java.util.*;
import static java.util.Collections.*;

public class JLS_7_5_3_StaticImport_3 {
    public static void main(String args[]) {
	ArrayList<Integer> al = new ArrayList();
	addAll(al,1,2,3,4,5);
	System.out.println(al);
    }
}