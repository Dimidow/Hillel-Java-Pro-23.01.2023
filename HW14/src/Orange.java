public class Orange implements Fruit {

    private static int orangeCount;
    private final float orangeWeight = 1.5F;

    public Orange() {
        orangeCount++;
    }

    @Override
    public float getFruitWeight() {
        return orangeWeight;
    }

    @Override
    public int getFruitCount() {
        return orangeCount;
    }
}
