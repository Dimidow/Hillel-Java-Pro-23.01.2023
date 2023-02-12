public class HomeWorkApp {

    public static void main(String[] args) {
        System.out.println("\nresult of printThreeWords():");
        printThreeWords();
        System.out.println("\nresult of checkSumSign():");
        checkSumSign();
        System.out.println("\nresult of printColor():");
        printColor();
        System.out.println("\nresult of compareNumbers():");
        compareNumbers();
        System.out.println("\nresult of isSumLiesInInterval():");
        System.out.println(isSumLiesInInterval(13, 8));
        System.out.println("\nresult of checkPositiveOrNegativeNumber():");
        checkPositiveOrNegativeNumber(-1);
        System.out.println("\nresult of isPositiveOrNegativeNumber():");
        System.out.println(isPositiveOrNegativeNumber(0));
        System.out.println("\nresult of printSpecifiedNumberOfTimes():");
        printSpecifiedNumberOfTimes(13, 5);
        System.out.println("\nresult of isYearLeap():");
        System.out.println(isYearLeap(800));
    }

    private static void printThreeWords() {
        System.out.println("Orange" + "\n" + "Banana" + "\n" + "Apple");
    }

    private static void checkSumSign() {
        int a = 10;
        int b = -1;
        int sum = a + b;
        System.out.println(sum >= 0 ? "Sum is positive" : "Sum is negative");
    }

    private static void printColor() {
        int value = 100;
        if (value <= 0) {
            System.out.println("Red");
        }
        if (value >= 0 && value <= 100) {
            System.out.println("Yellow");
        }
        if (value >= 100) {
            System.out.println("Green");
        }
    }

    private static void compareNumbers() {
        int a = 13;
        int b = 7;
        System.out.println(a >= b ? "a >= b" : "a < b");
    }

    private static boolean isSumLiesInInterval(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    private static void checkPositiveOrNegativeNumber(int a) {
        System.out.println(a >= 0 ? "Number is positive" : "Number is negative");
    }

    private static boolean isPositiveOrNegativeNumber(int a) {
        return a >= 0;
    }

    private static void printSpecifiedNumberOfTimes(int row, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(row);
        }
    }

    private static boolean isYearLeap(int year) {
        return !(year % 4 != 0 || (year % 100 == 0 && year % 400 != 0));
    }
}