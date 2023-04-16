import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Product {

    private static final String DATE_PATTERN = "dd-MM-yyyy";
    private String type;
    private double price;
    private boolean isDiscountApplied;
    private String category;
    private LocalDate date;

    public Product(String category) {
        this.category = category;
    }

    public Product(String type, double price, boolean isDiscountApplied, LocalDate date) {
        this.type = type;
        this.price = price;
        this.isDiscountApplied = isDiscountApplied;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscountApplied() {
        return isDiscountApplied;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Product> getProducts(List<Product> productsList) {
        return productsList.stream()
                           .filter(product -> Objects.equals(product.getType(), category))
                           .filter(product -> product.getPrice() > 250)
                           .collect(Collectors.toList());
    }

    public List<Product> getProductsWithDiscount(List<Product> productsList) {
        return productsList.stream()
                           .filter(product -> Objects.equals(product.getType(), category))
                           .filter(Product::isDiscountApplied)
                           .map(product -> {
                               product.setPrice(product.getPrice() * 0.9);
                               return product;
                           })
                           .collect(Collectors.toList());
    }

    public Product getLeastExpensiveBook(List<Product> productsList) throws Exception {
        return productsList.stream()
                           .filter(product -> Objects.equals(product.getType(), category))
                           .min(Comparator.comparingDouble(Product::getPrice))
                           .orElseThrow(() -> new Exception("Product category: " + category + " not found"));
    }

    public List<Product> getLastThreeAddedProducts(List<Product> productsList) {
        int size = productsList.size();
        if (size <= 3) {
            return productsList;
        }
        return productsList.subList(size - 3, size);
    }

    public List<Product> getThisYearProductWithBookTypeAndFixedPrice(List<Product> productList) {
        return productList.stream()
                          .filter(product -> product.getDate().getYear() == LocalDate.now().getYear())
                          .filter(product -> Objects.equals(product.getType(), category))
                          .filter(product -> product.getPrice() < 75)
                          .collect(Collectors.toList());
    }

    public Map<String, List<Product>> sortProductsByType(List<Product> productList) {
        return productList.stream()
                          .sorted(Comparator.comparing(Product::getType))
                          .collect(Collectors.groupingBy(Product::getType));
    }

    @Override
    public String toString() {
        return "Product{" +
               "type='" + type + '\'' +
               ", price=" + price +
               ", isDiscountApplied=" + isDiscountApplied +
               ", createDate=" + date.format(DateTimeFormatter.ofPattern(DATE_PATTERN)) +
               '}';
    }
}