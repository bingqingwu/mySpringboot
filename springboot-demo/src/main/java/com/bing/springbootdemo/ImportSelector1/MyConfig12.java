package com.bing.springbootdemo.ImportSelector1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MyAnnotation(name = "MyCofnig12")
public class MyConfig12 {
    public MyConfig12() {
        log.info("MyConfig12 construct...");
    }
}
