import org.example.BasicMathLibrary;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicMathLibraryTest {

    @Test
    public void testAdd() {
        double result = BasicMathLibrary.add(2, 3);
        assertEquals(5, result, 0.001);
    }

    @Test
    public void testSubtract() {
        double result = BasicMathLibrary.subtract(5, 3);
        assertEquals(2, result, 0.001);
    }

    @Test
    public void testMultiply() {
        double result = BasicMathLibrary.multiply(2, 3);
        assertEquals(6, result, 0.001);
    }

    @Test
    public void testDivide() {
        double result = BasicMathLibrary.divide(6, 3);
        assertEquals(2, result, 0.001);
    }

    @Test
    public void testPower() {
        double result = BasicMathLibrary.power(2, 3);
        assertEquals(8, result, 0.001);
    }

    @Test
    public void testSquareRoot() {
        double result = BasicMathLibrary.squareRoot(16);
        assertEquals(4, result, 0.001);
    }
}
