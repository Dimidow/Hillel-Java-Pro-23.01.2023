public class Tasks {

    public void printThreeWords() {
        System.out.println("Orange" + "\n" + "Banana" + "\n" + "Apple");
    }

    public void checkSumSign() {
        int a = 10;
        int b = -1;
        int sum = a + b;
        System.out.println(sum >= 0 ? "Sum is positive" : "Sum is negative");
    }

    public void printColor() {
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

    public void compareNumbers() {
        int a = 13;
        int b = 7;
        System.out.println(a >= b ? "a >= b" : "a < b");
    }

    public boolean isSumLiesInInterval(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public void checkPositiveOrNegativeNumber(int a) {
        System.out.println(a >= 0 ? "Number is positive" : "Number is negative");
    }

    public boolean isPositiveOrNegativeNumber(int a) {
        return a >= 0;
    }

    public void printSpecifiedNumberOfTimes(int row, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(row);
        }
    }

    public boolean isYearLeap(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 300 == 0) {
                return false;
            } else if (year % 400 == 0) {
                return true;
            } else return year % 100 != 0;
        } else {
            return false;
        }
    }
}
