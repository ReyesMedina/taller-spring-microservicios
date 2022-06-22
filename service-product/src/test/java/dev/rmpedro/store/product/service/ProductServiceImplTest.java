package dev.rmpedro.store.product.service;

import dev.rmpedro.store.product.entity.Category;
import dev.rmpedro.store.product.entity.Product;
import dev.rmpedro.store.product.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        productService=new ProductServiceImpl(productRepository);
        Product product01 = Product.builder()

                .category(Category.builder().id(1L).build()).createAt(new Date())
                .description("").name("computer")
                .price(Double.parseDouble("1240.99"))
                .status("Created")
                .stock(Double.parseDouble("10"))
                .build();

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product01));
        Mockito.when(productRepository.save(product01)).thenReturn(product01);

    }

    @Test
    void whenValidGetId_ThenReturnProduct() {
        Product found = productService.getProduct(1L);
        Assertions.assertTrue(found.getName().equals("computer"));
    }

    @Test
    void updateStock() {
        Product newStock = productService.updateStock(1L,8d);
        Assertions.assertTrue(newStock.getStock()==18);
    }
}