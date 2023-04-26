package com.bing.springbootdemo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {
    @Override
    @Async
    public void onApplicationEvent(MyApplicationEvent event) {
        log.info("MyApplicationListener: " + event.getMessage());
    }
}
