package patterns.strategy;

public class TriangleAreaStrategy implements ShapeAreaStrategy {

    private final double base;
    private final double height;

    public TriangleAreaStrategy(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return (base * height) / 2;
    }
}
