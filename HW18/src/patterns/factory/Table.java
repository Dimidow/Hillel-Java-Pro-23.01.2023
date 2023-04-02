package patterns.factory;

public class Table extends Furniture {

    @Override
    public void make() {
        System.out.println("The table was created");
    }
}
