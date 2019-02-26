package com.annotation.test.scope;

import com.annotation.driver.config.CommonConfig;
import com.annotation.driver.pojo.Person;
import org.junit.Test;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Blake on 2018/9/9
 */
public class ScopeTests {

    @Test
    public void singletonScopeTest1() {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CommonConfig.class);

        System.out.println(" ======== IOC容器初始化完成 ======== ");

        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        System.out.println(autowireCapableBeanFactory);
    }

    @Test
    public void singletonScopeTest2() {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CommonConfig.class);

        Person person1 = (Person) applicationContext.getBean("singletonPerson");

        Person person2 = (Person) applicationContext.getBean("singletonPerson");

        System.out.println(person1 == person2);

    }

    @Test
    public void prototypeScopeTest() {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CommonConfig.class);

        Person person1 = (Person) applicationContext.getBean("prototypePerson");

        Person person2 = (Person) applicationContext.getBean("prototypePerson");

        System.out.println(person1 == person2);

    }
}
