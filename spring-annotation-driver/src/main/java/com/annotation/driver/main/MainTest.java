package com.annotation.driver.main;

import com.annotation.driver.config.CommonConfig;
import com.annotation.driver.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Blake on 2018/9/9
 */
public class MainTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CommonConfig.class);

        Person person = applicationContext.getBean(Person.class);

        System.out.println(person);
    }
}
