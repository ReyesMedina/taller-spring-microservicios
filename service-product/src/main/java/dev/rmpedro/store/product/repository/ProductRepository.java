package dev.rmpedro.store.product.repository;

import dev.rmpedro.store.product.entity.Category;
import dev.rmpedro.store.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
     List<Product> findByCategory(Category category);
}
