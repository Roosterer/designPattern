package com.gk.代理模式.CGLIB动态代理;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by gaokuo on 2018/2/28.
 */
public class PersonMethodInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib proxy before");
        Object object = methodProxy.invokeSuper(o,objects);
        System.out.println("cglib proxy after");
        return object;
    }
}
