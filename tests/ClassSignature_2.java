import java.util.ArrayList;
import java.util.Collection;

public class ClassSignature_2<U> extends ArrayList<U> implements Collection<U> {
	
	public ClassSignature_2(U u) {
		super.add(u);
	}
	
	public static void main(String[] args) {
		ClassSignature_2<Integer> cs = new ClassSignature_2<Integer>(new Integer(1));
		for(Integer i : cs) {
			System.out.println(i.intValue());
		}
		
	}

}
