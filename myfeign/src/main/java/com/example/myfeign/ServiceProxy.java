package com.example.myfeign;



import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ServiceProxy<T> implements InvocationHandler {

    private Class<T> interfaceType;

    public ServiceProxy(Class<T> intefaceType) {
        this.interfaceType = interfaceType;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this,args);
        }
        String path = String.format("%s%s%s",method.getDeclaringClass().getAnnotation(Myfeign.class).url(),method.getAnnotation(GetMapping.class).value()[0],args[0]);

        HttpResponse<String> jsonResponse = Unirest.get(path)
                .header("accept", "application/json")
                .asString();

        return jsonResponse.getBody().toString();
    }
}

