package com.annotation.driver.config;

import com.annotation.driver.component.scan.type.filter.CustomTypeFilter;
import com.annotation.driver.condition.LinuxOsCondition;
import com.annotation.driver.condition.MacOsConditon;
import com.annotation.driver.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * Created by Blake on 2018/9/9
 */
@Configuration
/*@ComponentScan(basePackages = {"com.annotation.driver.component.scan"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Repository.class, Service.class})}
)*/

/*@ComponentScan(basePackages = {"com.annotation.driver.component.scan"},
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})}
)*/

@ComponentScan(basePackages = {"com.annotation.driver"},
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {CustomTypeFilter.class})}
)
public class CommonConfig {

    /**
     * @description: @Bean 创建bean，返回类型为方法返回值类型，beanId默认为方法名,若有填写value值，则beanId=value
     * @date: 2018/9/9
     * @author:Blake
     */
    @Bean(value = "person")
    public Person person001() {

        return new Person(18, "Blake");
    }

    @Bean
    @Scope(value = "singleton")
    @Lazy(value = false)
    public Person singletonPerson() {
        System.out.println(" ========== person bean 开始创建 ========== ");
        return new Person(19, "Blake");
    }

    @Bean
    @Scope(value = "prototype")
    public Person prototypePerson() {

        return new Person(20, "Blake");
    }

    /**
     * 懒加载 针对的是Singleton
     *
     * @return
     */
    @Bean
    @Scope(value = "singleton")
    @Lazy
    public Person lazySingletonPerson() {
        System.out.println("======== person bean 开始创建 ========");
        return new Person(21, "blake");
    }

    @Bean
    @Conditional({MacOsConditon.class})
    public Person conditionalPersonFirst() {

        return new Person(56, "Jobs");
    }

    @Bean
    @Conditional({LinuxOsCondition.class})
    public Person conditionalPersonSecond() {

        return new Person(48, "Linus");
    }

}
