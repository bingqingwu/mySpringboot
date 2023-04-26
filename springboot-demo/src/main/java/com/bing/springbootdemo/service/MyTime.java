package com.bing.springbootdemo.service;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class MyTime implements InitializingBean, DisposableBean, ApplicationContextAware {

    @Autowired
    private Environment env;

    private ApplicationContext applicationContext;

    public MyTime() {
        log.info("MyTime Construct");
    }

    @PostConstruct
    public void init() {
        log.info("MyTime init...");
    }

    @EventListener
    public void onContextRefreshedEvent(ContextRefreshedEvent event) {
        log.info("MyTime Invoke ContextRefreshedEvent, get env = {}" , env.getDefaultProfiles());
    }

    public void testTime() {
        String now = DateUtil.now();
        log.info("now: " + now);

        DateTime tomorrow = DateUtil.tomorrow();
        String tomorrowStr = DateUtil.format(tomorrow, DatePattern.NORM_DATETIME_PATTERN);
        log.info("tomorrowStr: " + tomorrowStr);

        DateTime dateTime = DateUtil.nextWeek();
        String nextWeek = DateUtil.format(dateTime, DatePattern.NORM_DATETIME_PATTERN);
        log.info("nextWeek: " + nextWeek);
    }

    public static void main(String[] args) {
        MyTime myTime = new MyTime();
        myTime.testTime();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("MyTime afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        log.info("MyTime destroy");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("MyTime setApplicationContext ");
        this.applicationContext = applicationContext;
    }

}