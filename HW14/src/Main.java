import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static <T> List<T> toList(T[] a) {
        if (a == null) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(a).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Integer[] someInts = {1, 13, 15, 22, 7};


        Apple apple = new Apple();
        List<Apple> appleList = new ArrayList<Apple>() {
            {
                add(new Apple());
                add(new Apple());
                add(new Apple());
                add(new Apple());
            }
        };
        Box<Apple> appleBox = new Box<>();

        Orange orange = new Orange();
        List<Orange> orangeList = new ArrayList<Orange>() {
            {
                add(new Orange());
                add(new Orange());
                add(new Orange());
            }
        };
        Box<Orange> orangeBox = new Box<>();

        try {
            System.out.println("\nresult of toList(): " + toList(someInts));

            System.out.println("adding an apple to appleBox:");
            appleBox.addFruitToBox(apple);

            System.out.println("adding apples to appleBox:");
            appleBox.addFruitToBox(appleList);

            System.out.println("\nadding an orange to orangeBox:");
            orangeBox.addFruitToBox(orange);

            System.out.println("adding oranges to orangeBox:");
            orangeBox.addFruitToBox(orangeList);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Null input " + illegalArgumentException);
        }

        System.out.println("\ngetting weight of appleBox:");
        System.out.println(appleBox.getBoxWeight());

        System.out.println("getting weight of orangeBox:");
        System.out.println(orangeBox.getBoxWeight());

        System.out.println("Comparing two boxes weight:");
        System.out.println(appleBox.compare(orangeBox));

        Box<Apple> appleBoxTwo = new Box<>();
        System.out.println("\nadding apples to appleBox:");
        appleBoxTwo.addFruitToBox(appleList);

        System.out.println("Merging boxes:");
        appleBox.mergeBoxes(appleBoxTwo);

        System.out.println("\ngetting weight of appleBox:");
        System.out.println(appleBox.getBoxWeight());
    }
}