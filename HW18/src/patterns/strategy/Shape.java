package patterns.strategy;

public class Shape {
    private ShapeAreaStrategy shapeAreaStrategy;

    public Shape(ShapeAreaStrategy shapeAreaStrategy) {
        this.shapeAreaStrategy = shapeAreaStrategy;
    }

    public double getArea(){
        return shapeAreaStrategy.calcArea();
    }
}
