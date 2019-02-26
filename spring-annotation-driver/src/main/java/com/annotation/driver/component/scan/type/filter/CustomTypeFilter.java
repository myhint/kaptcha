package com.annotation.driver.component.scan.type.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Set;

/**
 * Created by Blake on 2018/9/9
 * <p>
 * desc:自定义包扫描的过滤规则
 */
public class CustomTypeFilter implements TypeFilter {

    /**
     * @param metadataReader        目标类的元数据读取器
     * @param metadataReaderFactory 用于获取其他类（​​例如超类和接口）的元数据读取器的工厂
     * @description: 自定义实现包扫描的过滤规则
     * @date: 2018/9/9
     * @author:Blake
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        // 获取当前扫描到的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();

       /* for (String annotationType : annotationTypes) {
            System.out.println("注解类型：" + annotationType);
        }*/

        // 获取当前扫描到的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        String className = classMetadata.getClassName();
        System.out.println("===> 类名称：" + className);

        // 获取当前扫描到的类的资源信息（比如类路径）
        Resource resource = metadataReader.getResource();

//        String description = resource.getDescription();
//        System.out.println("description: " + description);

        if (className.contains("Example")) {
            return true;
        }

        return false;
    }

}
