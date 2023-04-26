package com.bing.springbootdemo.ImportSelector1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

@Slf4j
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        importingClassMetadata.getAllAnnotationAttributes(MyAnnotation.class.getName(), true).forEach(
                (k,v) -> {
                    log.info(importingClassMetadata.getClassName());
                    log.info("k:{}, v:{}", k, String.valueOf(v));
                }
        );
        return new String[0];
    }
}
