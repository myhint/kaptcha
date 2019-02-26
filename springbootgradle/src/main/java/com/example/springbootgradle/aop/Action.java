package com.example.springbootgradle.aop;

import java.lang.annotation.*;

/**
 * Created by Blake on 2018/7/31
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {

    String value() default "";
}
