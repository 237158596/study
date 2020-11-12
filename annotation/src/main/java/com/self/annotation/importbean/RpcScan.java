package com.self.annotation.importbean;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Import(CImport.class)
@Documented
public @interface RpcScan {

    String[] basePackage();

}
