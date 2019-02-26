package com.example.springbootgradle.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Blake on 2018/8/12
 */
@Component
@Data
@NoArgsConstructor
public class Book {

    @Value("${book.name}")
    private String name;

    @Value("${book.author}")
    private String author;

}
