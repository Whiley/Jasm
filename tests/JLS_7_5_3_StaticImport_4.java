import java.util.logging.Level;
import static java.util.logging.Level.*;

public class JLS_7_5_3_StaticImport_4 {
    static void trace(Level level, Object reason) {
	System.out.println("Hello World");
    }

    public static void main(String[] args) {
	trace(WARNING,"Hello world");
    }
}