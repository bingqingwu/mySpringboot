package com.bing.springbootdemo.beaninit;

import com.bing.springbootdemo.service.MyTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof MyTime){
            log.info("MyTime before: " + beanName);
        }
        //log.info("MyBeanPostProcessor before: "  + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof MyTime){
            log.info("MyTime after: " + beanName);
        }
        //log.info("MyBeanPostProcessor after: " + beanName);
        return bean;
    }
}
