public class FieldInit_1 {
    public int x = 1;
    public int y = (x=2) + 1; // Ok, this is just ridiculous!!!

    public static void main(String[] args) {
	FieldInit_1 fi1 = new FieldInit_1();
	System.out.println(fi1.x);
	System.out.println(fi1.y);
    }
}
