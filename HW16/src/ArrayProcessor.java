public class ArrayProcessor implements Runnable {
    private float[] arrayForCalc;

    public ArrayProcessor(float[] arrayForCalc) {
        this.arrayForCalc = arrayForCalc;
    }

    @Override
    public void run() {
        for (int i = 0; i < arrayForCalc.length; i++) {
            arrayForCalc[i] = (float)(arrayForCalc[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}

