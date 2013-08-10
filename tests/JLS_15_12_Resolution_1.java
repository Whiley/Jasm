public class Test {
    void f(Object o) {System.out.println("Object");}
    void f(String o) {System.out.println("String");}
    void f(Integer o) {System.out.println("Integer");}

    public static void main(String[] args) {
	new Test().f(null);
    }
} 