import org.my.homeworks.ArrayValues;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class ArrayValuesTest {

    private final ArrayValues arrayValues = new ArrayValues();

    @Test
    public void testExtractAfterLastFour() {
        int[] firstArray = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] firstExpectedValue = {1, 7};
        assertArrayEquals(firstExpectedValue, arrayValues.extractAfterLastFour(firstArray));

        int[] secondArray = {4, 2, 3, 1, 7};
        int[] secondExpectedValue = {2, 3, 1, 7};
        assertArrayEquals(secondExpectedValue, arrayValues.extractAfterLastFour(secondArray));

        int[] thirdArray = {1, 2, 3};
        assertThrows(RuntimeException.class, () -> arrayValues.extractAfterLastFour(thirdArray));

        int[] fourthArray = {4};
        int[] fourthExpectedValue = {};
        assertArrayEquals(fourthExpectedValue, arrayValues.extractAfterLastFour(fourthArray));
    }

    @Test
    public void testContainsOnlyFirstAndFourth() {
        int[] firstArray = {1, 1, 1, 4, 4, 1, 4, 4};
        assertTrue(arrayValues.containsOnlyFirstAndFourth(firstArray));

        int[] secondArray = {1, 1, 1, 1, 1, 1};
        assertFalse(arrayValues.containsOnlyFirstAndFourth(secondArray));

        int[] thirdArray = {4, 4, 4, 4};
        assertFalse(arrayValues.containsOnlyFirstAndFourth(thirdArray));

        int[] fourthArray = {1, 4, 4, 1, 1, 4, 3};
        assertFalse(arrayValues.containsOnlyFirstAndFourth(fourthArray));

        int[] fifthArray = {1, 1, 4, 4, 4};
        assertTrue(arrayValues.containsOnlyFirstAndFourth(fifthArray));

        int[] sixthArray = {1, 4};
        assertTrue(arrayValues.containsOnlyFirstAndFourth(sixthArray));

        int[] seventhArray = {1};
        assertFalse(arrayValues.containsOnlyFirstAndFourth(seventhArray));

        int[] arr8 = {4};
        assertFalse(arrayValues.containsOnlyFirstAndFourth(arr8));
    }
}
