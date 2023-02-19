import exceptions.ArrayDataException;
import exceptions.ArraySizeException;

public class ArrayValueCalculator {

    public static void main(String[] args) throws ArrayDataException, ArraySizeException {

        String[][] arrayForCalc = new String[][] {
            {"21", "()*)", "33", "41"},
            {"35", "**", "27", "18"},
            {"19", "10", "11", "*913"},
            {"9", "10", "11", "12"}
        };

        int dimension = 4;
        
        try {
            System.out.println("\nResult of doCalc():");
            System.out.println(doCalc(arrayForCalc, dimension));
        } catch (ArraySizeException e) {
            System.err.println(e.getMessage());
        } catch (ArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int doCalc(String[][] arrayForCalc, int dimension) throws ArraySizeException, ArrayDataException {

        int rows = arrayForCalc.length;
        int columns = arrayForCalc[0].length;

        if (rows != dimension || columns != dimension) {
            throw new ArraySizeException("Incorrect array dimension: " + dimension);
        }

        int sum = 0;
        int i = 0;
        int j = 0;

        try {
            for (; i < arrayForCalc.length; i++) {
                for (; j < arrayForCalc[0].length; j++) {
                    sum += Integer.parseInt(arrayForCalc[i][j]);
                }
            }
        } catch (NumberFormatException numberFormatException) {
            System.err.println("Incorrect value: " + arrayForCalc[i][j] + " on row " + i + " and col " + j + " " + numberFormatException.getMessage());
        }

        return sum;
    }
}