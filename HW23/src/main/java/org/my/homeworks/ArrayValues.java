package org.my.homeworks;

public class ArrayValues {
    public int[] extractAfterLastFour(int[] array) {
        int lastFourIndex = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                lastFourIndex = i;
                break;
            }
        }
        if (lastFourIndex == -1) {
            throw new RuntimeException("Array does not contain 4");
        }
        int[] result = new int[array.length - lastFourIndex - 1];
        System.arraycopy(array, lastFourIndex + 1, result, 0, result.length);
        return result;
    }

    public boolean containsOnlyFirstAndFourth(int[] array) {
        boolean containsFirst = false;
        boolean containsFourth = false;
        for (int elem : array) {
            if (elem == 1) {
                containsFirst = true;
            } else if (elem == 4) {
                containsFourth = true;
            } else {
                return false;
            }
        }
        return containsFirst && containsFourth;
    }
}
