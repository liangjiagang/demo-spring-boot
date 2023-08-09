package com.alagang.demo.springboot.util;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.List;

@Component
public class BeanUtil {

    @Resource
    private ApplicationContext applicationContext;

    public Object getBeanMethodData(String beanName, String methodName, Object... args) {
        Object bean = applicationContext.getBean(beanName);
        Assert.notNull(bean,    beanName+":Bean must not be null");
        Method[] methods = bean.getClass().getDeclaredMethods();
        Method method = null;
        for (Method m : methods) {
            if (m.getName().equals(methodName)) {
                method = m;
                break;
            }
        }
        Assert.notNull(method, beanName + ":" + methodName + ":Method must not be null");
        return ReflectionUtils.invokeMethod(method, bean, args);
    }


    public void printResultAsList(Object result) {
        if (result instanceof List) {
            List list = (List) result;
            for (Object o : list) {
                System.out.println(o);
            }
        }
    }
}
