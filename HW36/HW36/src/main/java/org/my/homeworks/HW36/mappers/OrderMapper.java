package org.my.homeworks.HW36.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.my.homeworks.HW36.entities.Order;
import org.my.homeworks.HW36.entities.Product;
import org.springframework.jdbc.core.RowMapper;

public class OrderMapper implements RowMapper<Order> {

    private ProductMapper productMapper;

    public OrderMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        int orderId = rs.getInt("order_id");
        Date orderDate = rs.getDate("order_date");
        double orderCost = rs.getDouble("order_cost");
        List<Product> products = new ArrayList<>();

        do {
            int productId = rs.getInt("product_id");
            String productName = rs.getString("product_name");
            double productCost = rs.getDouble("product_cost");
            Product product = new Product(productId, productName, productCost);
            products.add(product);
        } while (rs.next());

        return new Order(orderId, orderDate, orderCost, products);
    }
}