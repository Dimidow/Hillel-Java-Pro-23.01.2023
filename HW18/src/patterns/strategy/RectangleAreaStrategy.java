package patterns.strategy;

public class RectangleAreaStrategy implements ShapeAreaStrategy {

    private final double aSide;
    private final double bSide;

    public RectangleAreaStrategy(double aSide, double bSide) {
        this.aSide = aSide;
        this.bSide = bSide;
    }


    @Override
    public double calcArea() {
        return aSide * bSide;
    }
}
