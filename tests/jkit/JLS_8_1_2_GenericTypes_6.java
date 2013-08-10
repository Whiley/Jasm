import java.util.*;

public class JLS_8_1_2_GenericTypes_6 {
    public static void main(String[] args) {
	Set<String> ret = new HashSet<String>();
	String[] orig = ret.toArray(new String[0]);
	addAllFrom(orig);
	System.out.println("Got here");
    }

    private static void addAllFrom(String[] from) {	
    }
}     
