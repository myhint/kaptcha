package com.example.springbootgradle.controller;

import com.example.springbootgradle.aop.Action;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Blake on 2018/7/31
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    @Action("hello")
    public String hello() {

        return "Hello Spring boot Framework";
    }

}
