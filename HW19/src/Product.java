import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Product {

    private final String pattern = "dd-MM-yyyy";
    private String type;
    private double price;
    private boolean isDiscountApplied;
    private String category;
    private Date date;

    public Product(String category) {
        this.category = category;
    }

    public Product(String type, double price, boolean isDiscountApplied, Date date) {
        this.type = type;
        this.price = price;
        this.isDiscountApplied = isDiscountApplied;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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


    public Date getDate() {
        return date;
    }

    public List<Product> getProducts(List<Product> productsList) {
        return productsList.stream()
                           .filter(product -> product.getType().equals(category))
                           .filter(product -> product.getPrice() > 250)
                           .collect(Collectors.toList());
    }

    public List<Product> getProductsWithDiscount(List<Product> productsList) {
        return productsList.stream()
                           .filter(product -> product.getType().equals(category))
                           .filter(product -> product.isDiscountApplied())
                           .map(product -> {
                               product.setPrice((product.getPrice() * 0.9));
                               return product;
                           })
                           .collect(Collectors.toList());
    }

    public Product getLeastExpensiveBook(List<Product> productsList) throws Exception {
        return productsList.stream()
                           .filter(product -> product.getType().equals(category))
                           .min(Comparator.comparingDouble(Product::getPrice))
                           .orElseThrow(() -> new Exception("Product category: " + category + " not found"));
    }

    public List<Product> getLastThreeAddedProducts(List<Product> productsList) {
        return productsList.stream().skip(productsList.size() - 3).collect(Collectors.toList());
    }

    public List<Product> getThisYearProductWithBookTypeAndFixedPrice(List<Product> productList) {
        return productList.stream()
                          .filter(
                              product -> (1900 + product.getDate().getYear()) == LocalDate.now().getYear()) //This is trash =) working with old Date()`s methods
                          .filter(product -> product.getType().equals(category))
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
               ", createDate=" + new SimpleDateFormat(pattern).format(date) +
               '}';
    }
}
