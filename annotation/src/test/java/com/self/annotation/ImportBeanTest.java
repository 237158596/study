package com.self.annotation;

import com.self.annotation.importbean.C1;
import com.self.annotation.importbean.RpcScan;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



@RpcScan(basePackage = {"com.self.annotation.importbean"})
public class ImportBeanTest {

    @Test
    public  void  test(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(this.getClass());
        ctx.refresh();

        C1 ent = (C1)ctx.getBean("com.self.annotation.importbean.C1");
        System.out.println(ent);
        System.out.println(ent.getC1Name());
        ctx.close();
    }
}
