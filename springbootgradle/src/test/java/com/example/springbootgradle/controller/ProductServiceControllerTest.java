package com.example.springbootgradle.controller;

import com.example.springbootgradle.AbstractTest;
import com.example.springbootgradle.vo.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Blake on 2018/8/30
 */
//@RunWith(SpringRunner.class)
//@WebAppConfiguration
//@SpringBootTest
@Slf4j
public class ProductServiceControllerTest extends AbstractTest {

    @Before
    @Override
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getProductsList() throws Exception {
        String uri = "/products";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Product[] productList = super.mapFromJson(content, Product[].class);
        assertTrue(productList.length > 0);
        log.info("======>>" + mapToJson(productList));
    }

    @Test
    public void createProduct() throws Exception {
        String uri = "/products";
        Product product = new Product();
        product.setId("3");
        product.setName("Ginger");
        String inputJson = super.mapToJson(product);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Product is created successfully");
    }

    @Test
    public void updateProduct() throws Exception {
        String uri = "/products/2";
        Product product = new Product();
        product.setName("Lemon");
        String inputJson = super.mapToJson(product);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Product is updated successsfully");
    }

    @Test
    public void deleteProduct() throws Exception {
        String uri = "/products/2";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Product is deleted successsfully");
    }
}
