package patterns.factory;

public class Chair extends Furniture {

    @Override
    public void make() {
        System.out.println("The chair was created");
    }
}
