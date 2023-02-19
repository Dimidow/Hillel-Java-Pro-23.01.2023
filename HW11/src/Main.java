import coffee.order.CoffeeOrderBoard;

public class Main {

    public static void main(String[] args) {

        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

        coffeeOrderBoard.add("Alex");
        coffeeOrderBoard.add("Kolya");
        coffeeOrderBoard.add("Petro");
        coffeeOrderBoard.add("Petro");
        coffeeOrderBoard.add("Kolya");

        System.out.println("\nresult of deliver():");
        System.out.println(coffeeOrderBoard.deliver());
        System.out.println("\nresult of deliver() with arg:");
        System.out.println(coffeeOrderBoard.deliver(3));
        System.out.println("\nresult of draw():");
        coffeeOrderBoard.draw();
    }
}