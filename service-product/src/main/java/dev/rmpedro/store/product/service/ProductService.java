package dev.rmpedro.store.product.service;

import dev.rmpedro.store.product.entity.Category;
import dev.rmpedro.store.product.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    List<Product> listAllProduct();
    Product getProduct(Long id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product deleteProduct(Long id);
    List<Product> findByCategory(Category category);
    Product updateStock(Long id, Double quantity);

}
