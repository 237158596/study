package com.self.annotation.importbean.userpackagescan;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Import(ImportBeanDefinitionRegistrarStyle.class)
@Documented
public @interface Rs {

    String[] basePackage();
}
