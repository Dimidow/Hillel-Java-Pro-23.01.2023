import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> threadSafeList = new ThreadSafeList<String>();
        String stringObjectForThreadSafeList = "String";

        new Thread(() -> {
            System.out.println("\nresult of remove() in new Thread:");
            System.out.println(threadSafeList.remove("non-existing element"));
        }).start();
        new Thread(() -> {
            System.out.println("\nadd() in new Thread.");
            System.out.println(threadSafeList.add(stringObjectForThreadSafeList));
        }).start();

        new Thread(() -> {
            System.out.println("\nresult of get() in new Thread:");
            System.out.println(threadSafeList.get(threadSafeList.indexOf(stringObjectForThreadSafeList)));
        }).start();

        PetrolStation petrolStation = new PetrolStation(13000);
        System.out.println("\nresult of doRefuel() in new Threads:");
        new Thread(() -> {
            petrolStation.doRefuel(7000);
        }).start();

        new Thread(() -> {
            petrolStation.doRefuel(3000);
        }).start();

        new Thread(() -> {
            petrolStation.doRefuel(2000);
        }).start();

        new Thread(() -> {
            petrolStation.doRefuel(2000);
        }).start();

    }
}