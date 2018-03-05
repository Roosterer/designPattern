package com.gk.代理模式.CGLIB动态代理;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by gaokuo on 2018/2/28.
 */
public class ProxyTest {

    public static void main(String[] args) {

        //创建增强器
        Enhancer enhancer = new Enhancer();
        //指定要代理的类或接口
        enhancer.setSuperclass(PersonImp.class);
        //设置方法调用的增强类，方法回调，可在方法前后加入事务操作
        enhancer.setCallback(new PersonMethodInterceptor());
        //创建代理类
        PersonImp personProxy = (PersonImp) enhancer.create();
        //调用代理方法也就是委托方法，因为代理类继承了委托类
        personProxy.sayHello();
    }

}
