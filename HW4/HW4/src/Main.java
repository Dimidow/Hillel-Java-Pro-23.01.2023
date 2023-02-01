public class Main {

    public static void main(String[] args) {

        Animals animals = new Animals(); //Here is the 6-th time we used Class.

        Dogs dogOne = new Dogs("Sharik");
        Dogs dogTwo = new Dogs("Bobik");
        Dogs dog3 = new Dogs("Bobik");
        dogOne.run(50);
        dogOne.swim(10);
        dogTwo.run(40);
        dogTwo.swim(9);

        Cats cats = new Cats("Rudyi");
        Cats catsTwo = new Cats("Barsik");
        cats.run(180);
        cats.swim(15);
        catsTwo.run(10);
        catsTwo.swim(1);

        System.out.println("All of animals: " + animals.animalCounter +
                           " . Dogs: " + Dogs.dogsCounter + " . Cats: " + Cats.catsCounter);
    }
}