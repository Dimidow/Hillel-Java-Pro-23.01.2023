public class Cat extends Animals {

    private static int catsCounter = 0;

    public Cat(String name) {
        super(name);
        catsCounter++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(this.getName() + " runs " + distance + " m");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(this.getName() + " can not swim even " + distance + " m");
    }

    protected static int getCatsCounter() {
        return catsCounter;
    }
}
