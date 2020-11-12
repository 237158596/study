package com.self.annotation;

import com.self.annotation.importbean.userpackagescan.Class3;
import com.self.annotation.importbean.userpackagescan.Rs;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



@Rs(basePackage = {"com.self.annotation.importbean.userpackagescan"})
public class ImportBeanWithPackageScan {

    @Test
    public  void  test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ImportBeanWithPackageScan.class);
        ctx.refresh();

        System.out.println(ctx.getBean(Class3.class));

        ctx.close();
    }

}
