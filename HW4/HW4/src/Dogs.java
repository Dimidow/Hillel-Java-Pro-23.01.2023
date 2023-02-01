public class Dogs extends Animals {

    public static int dogsCounter;
    private final String name;

    public Dogs(String name) {
        this.name = name;
        dogsCounter++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(name + " runs " + distance + " m");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(name + " swims " + distance + " m");
        }
    }
}
