package org.example;

public class BasicMathLibrary {
    public static double add(double x, double y) {
        return x + y;
    }

    public static double subtract(double x, double y) {
        return x - y;
    }

    public static double multiply(double x, double y) {
        return x * y;
    }

    public static double divide(double x, double y) {
        return x / y;
    }

    public static double power(double x, double y) {
        return Math.pow(x, y);
    }

    public static double squareRoot(double x) {
        return Math.sqrt(x);
    }
}
