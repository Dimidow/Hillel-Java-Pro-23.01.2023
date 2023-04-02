import java.util.Arrays;

import patterns.builder.Car;
import patterns.factory.ChairFactory;
import patterns.factory.ClosetFactory;
import patterns.factory.Furniture;
import patterns.factory.FurnitureFactory;
import patterns.factory.TableFactory;
import patterns.strategy.RectangleAreaStrategy;
import patterns.strategy.Shape;
import patterns.strategy.TriangleAreaStrategy;

public class Main {

    public static void main(String[] args) {
        FurnitureFactory tableFactory = new TableFactory();
        FurnitureFactory chairFactory = new ChairFactory();
        FurnitureFactory closetFactory = new ClosetFactory();

        Furniture table = tableFactory.createFurniture();
        Furniture chair = chairFactory.createFurniture();
        Furniture closet = closetFactory.createFurniture();

        System.out.println("\nmake table():");
        table.make();
        System.out.println("\nmake chair():");
        chair.make();
        System.out.println("\nmake closet():");
        closet.make();

        Car car = new Car.CarBuilder("Honda CR-V")
                      .color("Grey")
                      .engine("Gas")
                      .transmission("Automatic")
                      .drivetrain("Normal, front")
                      .wheelSize(17)
                      .options(Arrays.asList("MP3", "A/B climate", "ABS"))
                      .build();

        System.out.println("\ncreate a car with Builder pattern:");
        System.out.println(car);

        Shape rectangle = new Shape(new RectangleAreaStrategy(8.4, 13.2));
        Shape triangle = new Shape(new TriangleAreaStrategy(5, 7));

        System.out.println("\ncalc rectangle shape with Strategy pattern:");
        System.out.println(rectangle.getArea());
        System.out.println("\ncalc triangle shape with Strategy pattern:");
        System.out.println(triangle.getArea());
    }
}