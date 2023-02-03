public class Dog extends Animals {

    private static int dogsCounter = 0;

    public Dog(String name) {
        super(name);
        dogsCounter++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(this.getName() + " runs " + distance + " m");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(this.getName() + " swim " + distance + " m");
        }
    }

    protected static int getDogsCounter() {
        return dogsCounter;
    }
}
