public class Main {

    public static void main(String[] args) {

        Animals animals = new Animals(); //Here is the 6-th time we used Class.

        Dog dogFirst = new Dog("Sharik");
        Dog dogSecond = new Dog("Bobik");
        Dog dogThird = new Dog("Bobik");
        dogFirst.run(50);
        dogFirst.swim(10);
        dogSecond.run(40);
        dogSecond.swim(9);

        Cat catFirst = new Cat("Rudyi");
        Cat catSecond = new Cat("Barsik");
        catFirst.run(180);
        catFirst.swim(15);
        catSecond.run(10);
        catSecond.swim(1);

        System.out.println("All of animals: " + animals.animalCounter +
                           " . Dogs: " + Dog.dogsCounter + " . Cats: " + Cat.catsCounter);
    }
}