package com.bing.springbootdemo.ImportSelector;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

@Slf4j
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        log.info("MyImportSelector....");
        return new String[]{MyConfig1.class.getName(), MyConfig2.class.getName()};
    }
}
