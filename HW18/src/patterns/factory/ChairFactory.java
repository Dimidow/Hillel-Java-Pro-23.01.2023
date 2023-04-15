package patterns.factory;

public class ChairFactory implements FurnitureFactory {

    @Override
    public Furniture createFurniture() {
        return new Chair();
    }
}
