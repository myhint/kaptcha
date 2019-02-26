package com.example.springbootgradle.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Blake on 2018/8/12
 */
@Data
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "author")
public class Author {

    private String name;

    private Integer age;

}
