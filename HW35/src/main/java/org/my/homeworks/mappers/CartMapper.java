package org.my.homeworks.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.my.homeworks.models.Cart;
import org.my.homeworks.models.Product;
import org.springframework.jdbc.core.RowMapper;

public class CartMapper implements RowMapper<Cart> {

    private ProductMapper productMapper;

    public CartMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        int cartId = rs.getInt("cart_id");
        List<Product> products = new ArrayList<>();
        do {
            int productId = rs.getInt("product_id");
            String productName = rs.getString("product_name");
            double productPrice = rs.getDouble("product_price");
            Product product = new Product(productId, productName, productPrice);
            products.add(product);
        } while (rs.next());
        return new Cart(cartId, products);
    }
}