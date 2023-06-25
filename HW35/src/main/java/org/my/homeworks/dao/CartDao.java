package org.my.homeworks.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.my.homeworks.mappers.CartMapper;
import org.my.homeworks.mappers.ProductMapper;
import org.my.homeworks.models.Cart;
import org.my.homeworks.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartDao implements StoreDao<Cart> {

    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(ProductDao.class);

    @Autowired
    public void init(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add(Cart item) {
        String insertCartQuery = "INSERT INTO Cart (id) VALUES (?)";
        String insertCartProductQuery = "INSERT INTO CartProduct (cart_id, product_id) VALUES (?, ?)";

        jdbcTemplate.update(insertCartQuery, item.getCartId());

        List<Object[]> batchValues = new ArrayList<>();
        for (Product product : item.getProducts()) {
            Object[] params = {item.getCartId(), product.getId()};
            batchValues.add(params);
        }

        jdbcTemplate.batchUpdate(insertCartProductQuery, batchValues);
        logger.info("Added cart: {}", item);
    }

    @Override
    public void delete(int id) {
        String deleteCartProductQuery = "DELETE FROM CartProduct WHERE cart_id = ?";
        jdbcTemplate.update(deleteCartProductQuery, id);
        String deleteQuery = "DELETE FROM Cart WHERE id = ?";
        jdbcTemplate.update(deleteQuery, id);
        logger.info("Cart was removed: {}", "id=" + id);
    }

    @Override
    public Cart getById(int id) {
        String query = "SELECT c.id AS cart_id, p.id AS product_id, p.name AS product_name, p.price AS product_price " +
                       "FROM Cart c " +
                       "JOIN CartProduct cp ON c.id = cp.cart_id " +
                       "JOIN Products p ON cp.product_id = p.id " +
                       "WHERE c.id = ?";
        Cart cart = jdbcTemplate.queryForObject(query, new Object[]{id}, new CartMapper(new ProductMapper()));
        logger.info("Get product by id:" + id + " {}", cart);
        return cart;
    }
}
