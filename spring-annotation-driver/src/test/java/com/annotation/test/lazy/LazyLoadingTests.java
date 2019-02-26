package com.annotation.test.lazy;

import com.annotation.driver.config.CommonConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Blake on 2018/9/9
 */
public class LazyLoadingTests {

    @Test
    public void lazyLoadingTest() {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CommonConfig.class);

        System.out.println(" ======= IOC容器初始化完成 ======== ");

//        Person person = (Person) applicationContext.getBean("lazySingletonPerson");
//        System.out.println(person);
    }
}
