package com.annotation.test.conditional;

import com.annotation.driver.config.CommonConfig;
import com.annotation.driver.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * Created by Blake on 2018/9/9
 */
public class ConditionalTests {

    /**
     * @Conditional 可应用于method&class
     * <p>
     * 即满足条件，则进行相关操作，如bean的创建（和@Bean配合使用）
     */
    @Test
    public void conditionalTest() {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CommonConfig.class);
        Environment environment = applicationContext.getEnvironment();

        String osName = environment.getProperty("os.name");

        System.out.println("the current operation system is : " + osName);

        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);

        if (beansOfType.containsKey("conditionalPersonSecond")) {
            Person person = beansOfType.get("conditionalPersonSecond");
            System.out.println(person);
        } else if (beansOfType.containsKey("conditionalPersonFirst")) {
            Person person = beansOfType.get("conditionalPersonFirst");
            System.out.println(person);
        }

    }

}
