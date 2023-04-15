import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Product product = new Product("Book");
        List<Product> products = new ArrayList<Product>() {
            {
                add(new Product("Milk", 25, false, new Date()));
                add(new Product("Apple", 10, false, new Date()));
                add(new Product("Book", 251, true, new Date()));
                add(new Product("Book", 300, true, new Date()));
                add(new Product("Book", 70, false, new Date()));
            }
        };
        System.out.println("result of searching Product with category 'Book' and price > 250");
        System.out.println(product.getProducts(products));
        System.out.println("\nresult of searching Product with category 'Book' and set discount 10%");
        System.out.println(product.getProductsWithDiscount(products));


        try {
            System.out.println("\nresult of getLeastExpensiveBook():");
            System.out.println(product.getLeastExpensiveBook(products));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nresult of searching last three added products");
        System.out.println(product.getLastThreeAddedProducts(products));
        System.out.println("\nresult of getThisYearProductWithBookTypeAndFixedPrice():");
        System.out.println(product.getThisYearProductWithBookTypeAndFixedPrice(products));
        System.out.println("\nresult of sortProductsByType():");
        System.out.println(product.sortProductsByType(products));
    }
}