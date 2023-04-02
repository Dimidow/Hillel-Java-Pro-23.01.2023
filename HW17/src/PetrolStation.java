import java.util.concurrent.Semaphore;

public class PetrolStation {

    private int amount;
    private final int permitsCount = 3;
    private final Semaphore fuelSemaphore = new Semaphore(permitsCount);

    public PetrolStation(int amount) {
        this.amount = amount;
    }

    public synchronized void doRefuel(int fuelAmount){
        try{
            fuelSemaphore.acquire();
            System.out.println("Refuel is starting for " + fuelAmount + " liters");
            Thread.sleep((long) (Math.random() * 8000 + 3000));
            if(amount >= fuelAmount){
                amount -= fuelAmount;
                System.out.println("Refueled successfully");
            } else {
                System.out.println("Not enough fuel");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            fuelSemaphore.release();
        }
    }
}
