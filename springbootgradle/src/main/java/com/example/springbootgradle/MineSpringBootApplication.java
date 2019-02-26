package com.example.springbootgradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

/**
 * 自定义配置演练：
 * <p>
 * 1、设定banner模式：off（关闭）
 * <p>
 * 2、通过Spring 提供的 @ImportResource 加载并读取 xml配置文件
 */

@SpringBootApplication
@ImportResource({"classpath:some-context.xml", "classpath:another-context.xml"})
public class MineSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MineSpringBootApplication.class, args);

//        SpringApplication application = new SpringApplication(MineSpringBootApplication.class);
//
//        // 关闭 banner
//        application.setBannerMode(Banner.Mode.OFF);
//        application.run(args);

    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
