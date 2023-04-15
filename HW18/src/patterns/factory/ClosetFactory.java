package patterns.factory;

public class ClosetFactory implements FurnitureFactory {

    @Override
    public Furniture createFurniture() {
        return new Closet();
    }
}
