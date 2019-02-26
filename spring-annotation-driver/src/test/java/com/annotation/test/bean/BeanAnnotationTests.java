package com.annotation.test.bean;

import com.annotation.driver.config.CommonConfig;
import com.annotation.driver.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Blake on 2018/9/9
 */
public class BeanAnnotationTests {

    @Test
    public void beanTest() {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CommonConfig.class);

        Object person = applicationContext.getBean(Person.class);

        System.out.println("person:" + person);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);

        for (String name : beanNamesForType) {
            System.out.println(name);
        }

    }


}
