import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String BOOK_CATEGORY = "Book";
    private static final String BOOK_LEAST_EXPENSIVE = "result of getLeastExpensiveBook():";
    private static final String SEARCH_BOOK_DISCOUNT = "result of searching Product with category 'Book' and set discount 10%";
    private static final String SEARCH_BOOK_PRICE = "result of searching Product with category 'Book' and price > 250";
    private static final String SEARCH_LAST_ADDED = "result of searching last three added products";
    private static final String SORT_PRODUCTS = "result of sortProductsByType():";
    private static final String THIS_YEAR_BOOK_FIXED_PRICE = "result of getThisYearProductWithBookTypeAndFixedPrice():";

    public static void main(String[] args) {

        Product product = new Product(BOOK_CATEGORY);
        List<Product> products = new ArrayList<>();
        products.add(new Product("Milk", 25, false, LocalDate.now()));
        products.add(new Product("Apple", 10, false, LocalDate.now()));
        products.add(new Product(BOOK_CATEGORY, 251, true, LocalDate.now()));
        products.add(new Product(BOOK_CATEGORY, 300, true, LocalDate.now()));
        products.add(new Product(BOOK_CATEGORY, 70, false, LocalDate.now()));

        System.out.println(SEARCH_BOOK_PRICE);
        System.out.println(product.getProducts(products));

        System.out.println("\n" + SEARCH_BOOK_DISCOUNT);
        System.out.println(product.getProductsWithDiscount(products));

        try {
            System.out.println("\n" + BOOK_LEAST_EXPENSIVE);
            System.out.println(product.getLeastExpensiveBook(products));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println("\n" + SEARCH_LAST_ADDED);
        System.out.println(product.getLastThreeAddedProducts(products));

        System.out.println("\n" + THIS_YEAR_BOOK_FIXED_PRICE);
        System.out.println(product.getThisYearProductWithBookTypeAndFixedPrice(products));

        System.out.println("\n" + SORT_PRODUCTS);
        System.out.println(product.sortProductsByType(products));
    }
}