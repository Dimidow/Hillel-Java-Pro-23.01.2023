public class Main {

    public static void main(String[] args) {

        Dog dogFirst = new Dog("Sharik");
        Dog dogSecond = new Dog("Bobik");
        Dog dogThird = new Dog("Bobik");
        int dogsCounter = Dog.getDogsCounter();
        System.out.println("Dogs count: " + dogsCounter);

        dogFirst.run(50);
        dogFirst.swim(10);
        dogSecond.run(40);
        dogSecond.swim(9);

        Cat catFirst = new Cat("Rudyi");
        Cat catSecond = new Cat("Barsik");
        int catsCounter = Cat.getCatsCounter();
        System.out.println("Cats count: " + catsCounter);
        catFirst.run(180);
        catFirst.swim(15);
        catSecond.run(10);
        catSecond.swim(1);
        System.out.println("Animals count: " + Animals.getAnimalsCounter());
    }
}