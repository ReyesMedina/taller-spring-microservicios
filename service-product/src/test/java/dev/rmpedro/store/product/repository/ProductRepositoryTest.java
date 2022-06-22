package dev.rmpedro.store.product.repository;

import dev.rmpedro.store.product.entity.Category;
import dev.rmpedro.store.product.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByCategory() {
        Category category = new Category();
        category.setId(1L);
        Product product01 = Product.builder()

                .category(category).createAt(new Date())
                .description("").name("computer")
                .price(Double.parseDouble("1240.99"))
                .status("Created")
                .stock(Double.parseDouble("10"))
                .build();
        productRepository.save(product01);

        List<Product> founds = productRepository.findByCategory(product01
                .getCategory());

        Assertions.assertTrue(founds.size()==1);
    }
}