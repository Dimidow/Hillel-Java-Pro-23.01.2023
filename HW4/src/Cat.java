public class Cat extends Animals {


    public static int catsCounter;
    private final String name;

    public Cat(String name) {
        this.name = name;
        catsCounter++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " runs " + distance + " m");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance >= 0) {
            System.out.println(name + " can not swim");
        }
    }
}
