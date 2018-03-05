package com.gk.代理模式.JDK动态代理;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gaokuo on 2018/2/27.
 */
public class Test{
    public String name = "hello clone";

    public static void main(String[] args) throws Exception{

//        Class<?>[] interfaces = new Class[]{Student.class,TestClassLoad.class};
//        final Class<?>[] intfs = interfaces.clone();
//
//        intfs[0] = Student.class;
//        intfs[1] = Student.class;
//
//        for (Class<?> intf : intfs) {
//            System.out.println(intf.getName());
//        }

        AtomicInteger ai = new AtomicInteger();
        ai.addAndGet(1);
        System.out.println(ai);
    }
}
