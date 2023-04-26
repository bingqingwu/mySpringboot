package com.bing.springbootdemo.ImportSelector1;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


/**
 * @author 清
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Configuration
@Import(MyImportSelector.class)
public @interface MyAnnotation {
    String name() default "";
}
