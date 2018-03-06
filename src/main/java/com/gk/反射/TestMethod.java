package com.gk.反射;

import java.lang.reflect.Method;

/**
 * Created by gaokuo on 2018/3/6.
 */
public class TestMethod {

    public static void main(String[] args) throws Exception{

        Class c = MyPersonImp.class;

        //获取本类的所有公有，私有方法
        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        //获取本类及父类所有的public方法
        System.out.println("===============");
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        //调用重载的方法（方法名一致，方法参数不同）
        System.out.println("===============");
        MyPersonImp mi = (MyPersonImp) c.newInstance();

        //String参数
        Method sayHello = c.getDeclaredMethod("sayHello", String.class);
        sayHello.invoke(mi,"this is mes");

        //String，Integer参数
        Method sayHello1 = c.getDeclaredMethod("sayHello", String.class, Integer.class);
        sayHello1.invoke(mi,"this is mes",9999);

        //String，int
        Method sayHello2 = c.getDeclaredMethod("sayHello", String.class, int.class);
        sayHello1.invoke(mi,"this is mes",7777777);

        //私有方法
        Method say = c.getDeclaredMethod("say", null);
        say.setAccessible(true);
        say.invoke(mi,null);

        //静态方法
        Method sayStatic = c.getDeclaredMethod("sayStatic", null);
        sayStatic.invoke(null,null);


    }
}
