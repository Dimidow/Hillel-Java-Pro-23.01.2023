package patterns.factory;

public class Closet extends Furniture {

    @Override
    public void make() {
        System.out.println("Closet was created");
    }
}
