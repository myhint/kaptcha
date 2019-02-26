package com.example.springbootgradle.controller;

import com.example.springbootgradle.vo.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Blake on 2018/8/12
 */
@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private Book book;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/books")
    public String getBookInfos() throws JsonProcessingException {

        String ret = "book name :" + book.getName() + ",book author:" + book.getAuthor();
        System.out.println(ret);

        return objectMapper.writeValueAsString(book);
    }

}
