package dev.vikas.productservice;

import dev.vikas.productservice.Models.Category;
import dev.vikas.productservice.Repositories.CategoryRepository;
import dev.vikas.productservice.Repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceApplicationTests {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testQueries(){

        Category category = categoryRepository.findById(1L);
        System.out.println("Fetched a Category Object");

    }
}
