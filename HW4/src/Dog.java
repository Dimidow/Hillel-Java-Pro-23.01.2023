public class Dog extends Animals {

    public Dog(String name) {
        super(name);
        this.getAnimalCounter();
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
            System.out.println(this.getName() + " swims " + distance + " m");
        }
    }
}
