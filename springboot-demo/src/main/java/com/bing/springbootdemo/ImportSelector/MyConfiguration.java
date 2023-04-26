package com.bing.springbootdemo.ImportSelector;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
@Configuration
@Import(MyImportSelector.class)
public class MyConfiguration {
    public MyConfiguration(){
        log.info("MyConfiguration...");
    }
}
