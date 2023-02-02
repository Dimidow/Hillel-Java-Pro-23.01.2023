public abstract class Animals {

    private static int animalCounter;
    private final String name;


    public Animals(String name) {
        this.name = name;
        animalCounter++;
    }

    public String getName() {
        return name;
    }

    public void run(int distance) {
    }

    public void swim(int distance) {
    }

    protected int getAnimalCounter() {
        return animalCounter;
    }
}
