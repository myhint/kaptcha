package com.example.springbootgradle.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Created by Blake on 2018/9/24
 */
//@Component
@Slf4j
public class GlobalExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        Method method = null;

        if (Objects.nonNull(handler) && handler instanceof HandlerMethod) {
            method = ((HandlerMethod) handler).getMethod();
        }

        log.error(" =============== [{}] system error ============== ", method);
        log.error(" =============== exception: [{}] ============= ", ex);

        return null;

    }

}
