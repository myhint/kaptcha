package com.example.springbootgradle.service.order;

import com.example.springbootgradle.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Blake on 2018/8/30
 */
@Service
public class OrderService {

    @Autowired
    private ProductService productService;

    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    public String getProductName() {
        return productService.getProductName();
    }

}
