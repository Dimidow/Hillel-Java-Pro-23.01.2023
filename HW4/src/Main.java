public class Main {

    public static void main(String[] args) {

        Dog dogFirst = new Dog("Sharik");
        Dog dogSecond = new Dog("Bobik");
        Dog dogThird = new Dog("Bobik");
        int animalCounter = dogThird.getAnimalCounter();
        System.out.println("Dogs count: " + animalCounter);

        dogFirst.run(50);
        dogFirst.swim(10);
        dogSecond.run(40);
        dogSecond.swim(9);

        Cat catFirst = new Cat("Rudyi");
        Cat catSecond = new Cat("Barsik");
        int catsCounter = catSecond.getAnimalCounter() - animalCounter;
        System.out.println("Cats count: " + catsCounter);
        catFirst.run(180);
        catFirst.swim(15);
        catSecond.run(10);
        catSecond.swim(1);
    }
}