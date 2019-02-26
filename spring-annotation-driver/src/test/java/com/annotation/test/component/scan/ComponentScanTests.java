package com.annotation.test.component.scan;

import com.annotation.driver.config.CommonConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Blake on 2018/9/9
 */
public class ComponentScanTests {

    @Test
    public void componentScanTest() {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CommonConfig.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {

            System.out.println(beanDefinitionName);
        }

    }
}
