package com.gk.代理模式.JDK动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by gaokuo on 2018/2/27.
 */

//自定义代理前后需要做的事情
public class StudentInvocationHandle implements InvocationHandler {

    Object traget;//被代理的接口实现类
    StudentInvocationHandle(Object traget){
        this.traget = traget;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = null;

        try{
            //方法调用前处理，例如开启事务
            System.out.println(method.getName() + " before invok");

            //调用代理类方法
            ret = method.invoke(traget,args);

            //方法调用后处理，例如提交事务
            System.out.println(method.getName() + " after invok");
        }catch (Exception e){
            //方法调用异常处理，例如事务回滚
            System.out.println(method.getName() + " run exception");
            throw e;
        }
        return ret;
    }
}
