package com.pangu.annotation;

import com.pangu.entity.Annotation;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/*
 * @author:liuzhaolu
 * @createTime: 2020-01-16 17:10
 * @desc: 注册为bean文件
 */
public class MyBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry){
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(MyPropertyAnnotation.class.getName()));
        String name = attributes.getString("name");
        int age = attributes.getNumber("age");

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Annotation.class);
        beanDefinition.getPropertyValues().add("name", name);
        beanDefinition.getPropertyValues().add("age", age);
        BeanDefinitionHolder holder = new BeanDefinitionHolder(beanDefinition, "person");
        BeanDefinitionReaderUtils.registerBeanDefinition(holder,registry);
    }
}
