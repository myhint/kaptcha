package com.example.jenkins.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 调试用Hello 控制层
 * @Author blake
 * @Date 2019-02-26 10:49
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/hello")
@Slf4j
public class HelloJenkinsController {

    @GetMapping
    public String printHelloJenkins() {

        log.info("HelloJenkinsController.printHelloJenkins =========== hello,Jenkins debugging! =========== ");

        return "hello,Jenkins";
    }

}
