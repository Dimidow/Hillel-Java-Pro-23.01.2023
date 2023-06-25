package org.my.homeworks.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.my.homeworks.models.Product;
import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        int productId = rs.getInt("product_id");
        String productName = rs.getString("product_name");
        double productPrice = rs.getDouble("product_price");
        return new Product(productId, productName, productPrice);
    }
}
