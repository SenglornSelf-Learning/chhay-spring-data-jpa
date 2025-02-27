package com.springdatajpa.init;

import com.springdatajpa.entity.Product;
import com.springdatajpa.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitialization {
    private final ProductRepository productRepository;

//    public DataInitialization(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @PostConstruct
    void init() {
        System.out.println("Initializing Data");
        Product product1 = new Product();
        product1.setName("keyboard");
        product1.setDescription("Asus");
        product1.setPrice(BigDecimal.valueOf(15));

        Product product2 = new Product();
        product2.setName("computer");
        product2.setDescription("Mac Book");
        product2.setPrice(BigDecimal.valueOf(23));

        productRepository.saveAll(List.of(product1, product2));

        Product product3 = Product.builder()
                .name("monitor")
                .description("dragon")
                .price(BigDecimal.valueOf(40))
                .build();
        productRepository.save(product3);

        System.out.println("Product is create successfully");

        System.out.println(product1.getId());
        System.out.println(product2.getId());
        System.out.println(product3.getId());
        System.out.println(" ");

        System.out.println("Find All products ");
        List<Product> products = productRepository.findAll();
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
            System.out.println(" ");
        });
    }
}
