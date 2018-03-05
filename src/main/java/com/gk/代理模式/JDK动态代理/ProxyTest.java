package com.gk.代理模式.JDK动态代理;

import java.lang.reflect.Proxy;

/**
 * Created by gaokuo on 2018/2/27.
 */
public class ProxyTest {

    public static void main(String[] args) throws Exception{

        //创建一个学生接口实现
        Student student = new StudentImp("gaokuo");
        //创建一个调用处理类，将学生实现传入
        StudentInvocationHandle handle = new StudentInvocationHandle(student);
        //使用Proxy类实例化代理类，参数为：类加载器，接口数组，调用处理类；返回值强转为学生接口
        Student studentProxy = (Student)Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),new Class[]{Student.class},handle);
        //接口调用
        studentProxy.sayHello();

    }

}
