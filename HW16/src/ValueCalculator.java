public class ValueCalculator {

    private final float[] array = new float[10000000];
    private final int arrayLength = array.length;
    private final int halfOfArrayLength = (arrayLength + 1) / 2;
    private final float[] a1 = new float[halfOfArrayLength];
    private final float[] a2 = new float[halfOfArrayLength];


    public void mainMethod() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arrayLength; i++) {
            array[i] = 1;
        }

        System.arraycopy(array, 0, a1, 0, halfOfArrayLength);
        System.arraycopy(array, halfOfArrayLength, a2, 0, halfOfArrayLength);

        Thread thread1 = new Thread(new ArrayProcessor(a1));
        Thread thread2 = new Thread(new ArrayProcessor(a2));
        thread1.start();
        thread2.start();

        System.arraycopy(a1, 0, array, 0, halfOfArrayLength);
        System.arraycopy(a2, 0, array, halfOfArrayLength, halfOfArrayLength);


        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}
