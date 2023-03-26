public class Main {

    public static void main(String[] args) {
        ThreadSafeList threadSafeList = new ThreadSafeList();

        new Thread(() -> {
            System.out.println("\nresult of remove() in new Thread:");
            System.out.println(threadSafeList.remove("non-existing element"));
        }).start();
        new Thread(() -> {
            System.out.println("\nadd() in new Thread.");
            threadSafeList.add("some string Object");
        }).start();

        new Thread(() -> {
            System.out.println("\nresult of get() in new Thread:");
            System.out.println(threadSafeList.get("some string Object"));
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