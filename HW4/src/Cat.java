public class Cat extends Animals {

    public Cat(String name) {
        super(name);
        this.getAnimalCounter();
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(this.getName() + " runs " + distance + " m");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance >= 0) {
            System.out.println(this.getName() + " can not swim");
        }
    }
}
