public abstract class Animals {

    private static int animalsCounter = 0;
    private final String name;


    public Animals(String name) {
        this.name = name;
        animalsCounter++;
    }

    public String getName() {
        return name;
    }

    abstract public void run(int distance);

    abstract public void swim(int distance);

    protected static int getAnimalsCounter() {
        return animalsCounter;
    }
}
