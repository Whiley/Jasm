import java.util.ArrayList;

public class FieldSignature_1 {
	public ArrayList<Integer> f = new ArrayList<Integer>();
	
	public FieldSignature_1() {
		f.add(new Integer(1));
		f.add(new Integer(2));
	}

	public static void main(String[] args) {
		FieldSignature_1 fs = new FieldSignature_1();
		
		for(Integer s : fs.f) {
			System.out.println(s.intValue());
		}
	}
}
