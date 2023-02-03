package square;

import java.util.Arrays;

public class Calculation {

    public Double getSummarySquare() {
        return Arrays.stream(new double[] {
            new Square().getSquare(),
            new Triangle().getSquare(),
            new Circle().getSquare()
        }).sum();
    }
}