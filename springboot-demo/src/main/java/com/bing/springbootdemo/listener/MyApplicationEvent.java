package com.bing.springbootdemo.listener;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class MyApplicationEvent extends ApplicationEvent {

    private String message;

    public MyApplicationEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}
