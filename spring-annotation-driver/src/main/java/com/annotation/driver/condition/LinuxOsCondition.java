package com.annotation.driver.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

/**
 * Created by Blake on 2018/9/9
 */
public class LinuxOsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");

        if (Objects.nonNull(osName) && osName.contains("Linus")) {
            return true;
        }

        return false;
    }

}
