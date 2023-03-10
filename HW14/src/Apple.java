public class Apple implements Fruit {

    private static int appleCount;
    private final float appleWeight = 1.0F;

    public Apple() {
        appleCount++;
    }

    @Override
    public float getFruitWeight() {
        return appleWeight;
    }

    @Override
    public int getFruitCount() {
        return appleCount;
    }
}
