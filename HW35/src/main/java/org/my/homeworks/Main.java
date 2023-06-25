package org.my.homeworks;

import java.util.List;

import org.my.homeworks.dao.ProductDao;
import org.my.homeworks.dao.CartDao;
import org.my.homeworks.models.Cart;
import org.my.homeworks.models.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.my.homeworks");
        ProductDao productDao = applicationContext.getBean(ProductDao.class);
        CartDao cartDao = applicationContext.getBean(CartDao.class);

        List<Product> productList = productDao.getAvailableProducts();
        productDao.add(new Product(50, "Salt", 10.0));
        productDao.getById(50);
        productDao.delete(50);
        cartDao.add(new Cart(10, productList));
        cartDao.getById(10);
        cartDao.delete(10);

    }
}