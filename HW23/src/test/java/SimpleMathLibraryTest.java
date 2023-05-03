import org.my.homeworks.MyTestWatcher;
import org.my.homeworks.SimpleMathLibrary;
import org.junit.Rule;
import org.junit.Test;

public class SimpleMathLibraryTest {

    @Rule
    public MyTestWatcher watcher = new MyTestWatcher();

    @Test
    public void testAdd() {
        SimpleMathLibrary simpleMathLibrary = new SimpleMathLibrary();
        double result = simpleMathLibrary.add(2, 3);
        if (result == 5) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }

    @Test
    public void testMinus() {
        SimpleMathLibrary simpleMathLibrary = new SimpleMathLibrary();
        double result = simpleMathLibrary.minus(5, 2);
        if (result == 3) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }
}