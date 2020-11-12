package com.self.annotation.importbean.userpackagescan;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;

public class ImportBeanDefinitionRegistrarStyle implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {

    ResourceLoader resourceLoader;


    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        String[] a = new String[]{((StandardAnnotationMetadata) annotationMetadata).getIntrospectedClass().getPackage().getName()};

        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(Rs.class.getName()));
        CustomScanner rpcServiceScanner = new CustomScanner(beanDefinitionRegistry, MyConpent.class);
        rpcServiceScanner.setResourceLoader(resourceLoader);

        rpcServiceScanner.scan(annotationAttributes.getStringArray("basePackage"));


        Class<?> serviceRelatedInterface = annotationMetadata.getClass().getInterfaces()[0];
        String serviceName = serviceRelatedInterface.getCanonicalName();

    }


}
