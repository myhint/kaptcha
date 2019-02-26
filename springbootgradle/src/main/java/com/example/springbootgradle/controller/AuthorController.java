package com.example.springbootgradle.controller;

import com.example.springbootgradle.vo.Author;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Blake on 2018/8/12
 */
@RestController
public class AuthorController {

    @Autowired
    private Author author;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/api/authors")
    public String getAuthorInfos() throws JsonProcessingException {

        return objectMapper.writeValueAsString(author);
    }

}
