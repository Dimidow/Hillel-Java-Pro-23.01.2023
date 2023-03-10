import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private float boxWeight;
    private List<T> fruits;

    public void addFruitToBox(T t) {
        if (fruits == null) {
            fruits = new ArrayList<>();
        }
        fruits.add(t);
        System.out.println(t.getClass().getName() + " has added");
    }

    public void addFruitToBox(List<T> fruits) {
        if (fruits == null || fruits.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (this.fruits == null) {
            this.fruits = new ArrayList<>();
        }
        this.fruits.addAll(fruits);
        System.out.println(fruits.get(0).getClass().getName() + "s have added");
    }

    public float getBoxWeight() {
        if (fruits == null || fruits.isEmpty()) {
            return 0;
        }
        Fruit fruit = fruits.get(0);
        return boxWeight = fruit.getFruitWeight() * fruits.size();
    }

    public List<T> getFruits() {
        return fruits;
    }

    public boolean compare(Box box) {
        return boxWeight == box.getBoxWeight();
    }

    public void mergeBoxes(Box<T> box){
        addFruitToBox(box.getFruits());
    }
}
