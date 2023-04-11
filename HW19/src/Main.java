import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Product product = new Product("Book");
        List<Product> products = new ArrayList<Product>() {
            {
                add(new Product("Milk", 25, false));
                add(new Product("Apple", 10, false));
                add(new Product("Book", 251, true));
                add(new Product("Book", 300, true));
                add(new Product("Book", 150, false));
            }
        };
        System.out.println("\nresult of searching Product with category 'Book' and price > 250");
        System.out.println(product.getProducts(products));
        System.out.println("\nresult of searching Product with category 'Book' and set discount 10%");
        System.out.println(product.getProductsWithDiscount(products));


        try {
            System.out.println("\ngetLeastExpensiveBook");
            System.out.println(product.getLeastExpensiveBook(products));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}