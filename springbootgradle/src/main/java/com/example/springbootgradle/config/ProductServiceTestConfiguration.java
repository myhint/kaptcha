package com.example.springbootgradle.config;

import com.example.springbootgradle.service.product.ProductService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * Created by Blake on 2018/8/30
 */
@Profile("test")
@Configuration
public class ProductServiceTestConfiguration {

    @Bean
    @Primary
    public ProductService productService() {
        return Mockito.mock(ProductService.class);
    }

}
