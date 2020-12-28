package com.pangu.Monitor.rest;


import com.pangu.Monitor.mail.IMailService;
import com.pangu.Entity.RestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import javax.annotation.Resource;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-04 20:51
 * @desc:
 */
public class RestInfoAnnotation implements ImportBeanDefinitionRegistrar {

    private static final Logger logger = LoggerFactory.getLogger(RestInfoAnnotation.class);

    @Resource
    private IMailService iMailService;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry){
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(RestInfo.class.getName()));
        long start = System.currentTimeMillis();
        System.out.println("around time:" + start);

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(RestEntity.class);
//        beanDefinition.getPropertyValues().add("RemoteAddr", request.getRemoteAddr());
//        beanDefinition.getPropertyValues().add("RequestURL", request.getRequestURL().toString());
//        beanDefinition.getPropertyValues().add("Method", request.getMethod());
        beanDefinition.getPropertyValues().add("extra", "this is RestInfoAnnotation extra");
//        BeanDefinitionHolder holder = new BeanDefinitionHolder(beanDefinition, "Rest");
        registry.registerBeanDefinition("rest",beanDefinition);
    }
}
