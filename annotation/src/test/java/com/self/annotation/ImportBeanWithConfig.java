package com.self.annotation;

import com.self.annotation.importbean.C1;
import com.self.annotation.importbean.withconfig.C1config;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportBeanWithConfig {

    @Test
    public  void  test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(C1config .class);
        ctx.refresh();

        C1 ent = (C1) ctx.getBean(C1.class);
        System.out.println(ent.getC1Name());
        ctx.close();
    }

}
