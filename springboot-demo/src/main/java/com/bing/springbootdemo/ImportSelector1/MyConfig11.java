package com.bing.springbootdemo.ImportSelector1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MyAnnotation(name = "MyCofnig11")
public class MyConfig11 {
    public MyConfig11() {
        log.info("MyConfig11 construct...");
    }
}
