package org.my.homeworks.dao;

import java.util.List;
import javax.sql.DataSource;

import org.my.homeworks.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Repository
public class ProductDao implements StoreDao<Product> {

    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(ProductDao.class);

    @Autowired
    public void init(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add(Product item) {
        String insertQuery = "INSERT INTO Products (id, name, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(insertQuery, item.getId(), item.getName(), item.getPrice());
        logger.info("Added product: {}", item);
    }

    @Override
    public void delete(int id) {
        String deleteQuery = "DELETE FROM Products WHERE id = ?";
        jdbcTemplate.update(deleteQuery, id);
        logger.info("Product was removed: {}", "id=" + id);
    }

    @Override
    public Product getById(int id) {
        String query = "SELECT * FROM Products WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                logger.info("Get product by id:" + id + " {}", product);
                return product;
            }, id);
        } catch (EmptyResultDataAccessException e) {
            logger.error("Product with such id not found: {}", id, e);
            throw new RuntimeException("Product not found");
        }
    }

    public List<Product> getAvailableProducts(){
        return jdbcTemplate.query("SELECT * FROM Products", ((rs, rowNum) -> {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            logger.info("Get all available products: {}", product);
            return product;
        }));
    }
}
