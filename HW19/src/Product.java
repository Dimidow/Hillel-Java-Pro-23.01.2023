import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Product {

    private String type;
    private double price;

    private boolean isDiscountApplied;

    private String category;

    public Product(String category) {
        this.category = category;
    }

    public Product(String type, double price, boolean isDiscountApplied) {
        this.type = type;
        this.price = price;
        this.isDiscountApplied = isDiscountApplied;
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

    public void setDiscountApplied(boolean discountApplied) {
        isDiscountApplied = discountApplied;
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

    @Override
    public String toString() {
        return "Product{" +
               "type='" + type + '\'' +
               ", price=" + price +
               ", isDiscountApplied=" + isDiscountApplied +
               '}';
    }
}
