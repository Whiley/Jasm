import java.io.Serializable;
import java.util.ArrayList;

public class ClassSignature_1 extends ArrayList<Integer> implements Serializable {
	
	public ClassSignature_1() {
		super.add(new Integer(1));
		super.add(new Integer(2));
	}
	
	public static void main(String[] args) {
		ClassSignature_1 cs = new ClassSignature_1();
		
		for(Integer s : cs) {
			System.out.println(s.intValue());
		}
	}

}
