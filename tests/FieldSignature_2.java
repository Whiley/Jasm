import java.util.ArrayList;

public class FieldSignature_2<U> {
	
	public ArrayList<U> f = new ArrayList<U>();
	
	public FieldSignature_2(U u) {
		f.add(u);
	}
	
	public static void main(String[] args) {
		FieldSignature_2<Integer> fs = new FieldSignature_2<Integer>(new Integer(1));
		for(Integer i : fs.f) {
			System.out.println(i);
		}
	}

}
