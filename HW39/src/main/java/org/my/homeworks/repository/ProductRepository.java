package org.my.homeworks.repository;

import java.util.List;
import java.util.Optional;

import org.my.homeworks.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductRepository {

    private int productCounter = 0;
    @Autowired
    private CrudProductRepository crudProductRepository;

    public void createProduct(){
        Product product = new Product();
        product.setId(productCounter++);
        product.setName("Watermelon");
        product.setCost(13.0);
        crudProductRepository.save(product);
    }

    public List<Product> getAllProducts() {
       return (List<Product>) crudProductRepository.findAll();
    }

    public Optional<Product> getProductById(int id){
        return crudProductRepository.findById(id);
    }

    public void removeProduct(){
        crudProductRepository.deleteAll();
    }
}
