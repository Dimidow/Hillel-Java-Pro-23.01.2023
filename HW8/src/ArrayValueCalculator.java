import exceptions.ArrayDataException;
import exceptions.ArraySizeException;

public class ArrayValueCalculator {

    private static final StringBuilder incorrectData = new StringBuilder();

    public static void main(String[] args) {
        String[][] arrayForCalc = new String[][] {
            {"21", "()*)", "33", "41"},
            {"35", "**", "27", "18"},
            {"19", "10", "11", "*913"}
            /*, {"9", "10", "11", "12"}*/
        };
        int dimension = 4;

        System.out.println("\nResult of doCalc():");
        System.out.println(doCalc(arrayForCalc, dimension));
    }

    private static int doCalc(String[][] arrayForCalc, int dimension)
        throws ArraySizeException, ArrayDataException {

        int sum = 0;

        try {
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < arrayForCalc[dimension].length; j++) {
                    sum += Integer.parseInt(arrayForCalc[i][j]);
                }
            }
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            if
            (!isArraySizeValid(arrayForCalc, dimension)) {
                throw new ArraySizeException("Incorrect array dimension: " + dimension, arrayIndexOutOfBoundsException);
            }
        } catch (NumberFormatException numberFormatException) {
            if (!isArrayDataCorrect(arrayForCalc)) {
                throw new ArrayDataException(incorrectData + " ", numberFormatException);
            }
        }
        return sum;
    }

    private static boolean isArraySizeValid(String[][] arrayForCalc, int dimension) {
        int rows = arrayForCalc.length;
        int columns = arrayForCalc[0].length;
        return rows == dimension && columns == dimension;
    }

    private static boolean isArrayDataCorrect(String[][] arrayForCalc) {
        boolean isArrayDataCorrect = true;
        for (int i = 0; i < arrayForCalc.length; i++) {
            for (int j = 0; j < arrayForCalc[i].length; j++) {
                if (!arrayForCalc[i][j].matches("[-+]?\\d+")) {
                    incorrectData.append("\nIncorrect value: " + arrayForCalc[i][j] + " on row " + i + " and col " + j);
                    isArrayDataCorrect = false;
                }
            }
        }
        return isArrayDataCorrect;
    }
}