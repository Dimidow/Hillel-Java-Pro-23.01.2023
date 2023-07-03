package org.my.homeworks.HW36.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import org.my.homeworks.HW36.entities.Order;
import org.my.homeworks.HW36.entities.Product;
import org.my.homeworks.HW36.mappers.OrderMapper;
import org.my.homeworks.HW36.mappers.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class OrderDao implements StoreDao<Order>{

    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(OrderDao.class);

    @Autowired
    public void init(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add(Order order) {
        String insertOrderQuery = "INSERT INTO Orders (id, date, cost) VALUES (?, ?, ?)";
        String insertOrderProductQuery = "INSERT INTO OrderProduct (order_id, product_id) VALUES (?, ?)";
        jdbcTemplate.update(insertOrderQuery, order.getId(), order.getDate(), order.getCost());
        List<Object[]> batchValues = new ArrayList<>();
        for (Product product : order.getProducts()) {
            Object[] params = {order.getId(), product.getId()};
            batchValues.add(params);
        }
        jdbcTemplate.batchUpdate(insertOrderProductQuery, batchValues);
        logger.info("Added order: {}", order);
    }

    @Override
    public Order getById(int id) {
        String query = "SELECT o.id AS order_id, o.date AS order_date, o.cost AS order_cost, p.id AS product_id, p.name AS product_name, p.cost AS product_cost " +
                       "FROM Orders o " +
                       "JOIN OrderProduct op ON o.id = op.order_id " +
                       "JOIN Products p ON op.product_id = p.id " +
                       "WHERE o.id = ?";
        Order order = jdbcTemplate.queryForObject(query, new Object[]{id}, new OrderMapper(new ProductMapper()));
        logger.info("Get order by id: {} {}", id, order);
        return order;
    }

    @Override
    public List<Order> getAllEntities() {
        String query = "SELECT o.id AS order_id, o.date AS order_date, o.cost AS order_cost, p.id AS product_id, p.name AS product_name, p.cost AS product_cost " +
                       "FROM Orders o " +
                       "JOIN OrderProduct op ON o.id = op.order_id " +
                       "JOIN Products p ON op.product_id = p.id";
        List<Order> orders = jdbcTemplate.query(query, (rs, rowNum) -> {
            int orderId = rs.getInt("order_id");
            Date orderDate = rs.getDate("order_date");
            double orderCost = rs.getDouble("order_cost");
            int productId = rs.getInt("product_id");
            String productName = rs.getString("product_name");
            double productCost = rs.getDouble("product_cost");
            Product product = new Product(productId, productName, productCost);
            Order order = new Order(orderId, orderDate, orderCost, new ArrayList<>());
            order.getProducts().add(product);
            return order;
        });
        logger.info("Get all orders: {}", orders);
        return orders;
    }
    public List<Product> getAvailableProducts(){
        return jdbcTemplate.query("SELECT * FROM Products", ((rs, rowNum) -> {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setCost(rs.getDouble("cost"));
            logger.info("Get all available products: {}", product);
            return product;
        }));
    }
}
