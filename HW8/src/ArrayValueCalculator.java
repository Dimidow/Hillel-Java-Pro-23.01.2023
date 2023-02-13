import exceptions.ArrayDataException;
import exceptions.ArraySizeException;
import exceptions.DataException;

public class ArrayValueCalculator {

    public static void main(String[] args) throws ArraySizeException {

        String[][] arrayForCalc = new String[][] {
            {"21", "()*)", "33", "41"},
            {"35", "**", "27", "18"},
            {"19", "10", "11", "*913"},
            {"9", "10", "11", "12"}
        };

        int rows = arrayForCalc.length;
        int columns = arrayForCalc[0].length;
        int dimension = 4;

        if (rows != dimension || columns != dimension) {
            throw new ArraySizeException("Incorrect array dimension: " + dimension);
        }

        System.out.println("\nResult of doCalc():");
        System.out.println(doCalc(arrayForCalc, dimension));
    }

    private static int doCalc(String[][] arrayForCalc, int dimension) throws ArrayDataException {

        int sum = 0;
        int i = 0;
        int j = 0;

        try {
            for (; i < dimension - 1; i++) {
                for (; j < arrayForCalc[dimension - 1].length; j++) {
                    sum += Integer.parseInt(arrayForCalc[i][j]);
                }
            }
        } catch (NumberFormatException numberFormatException) {
            throw new ArrayDataException("Incorrect value: " + arrayForCalc[i][j] + " on row " + i + " and col " + j, numberFormatException);
        }

        return sum;
    }
}