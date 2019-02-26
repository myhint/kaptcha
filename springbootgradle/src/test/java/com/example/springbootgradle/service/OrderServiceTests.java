package com.example.springbootgradle.service;

import com.example.springbootgradle.service.order.OrderService;
import com.example.springbootgradle.service.product.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Blake on 2018/8/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class OrderServiceTests {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Test
    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {

        OngoingStubbing<String> when = Mockito.when(productService.getProductName());
        when.thenReturn("Mock Product Name");

        String testName = orderService.getProductName();
        Assert.assertEquals("Mock Product Name", testName);

    }

}
