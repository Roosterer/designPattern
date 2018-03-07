package com.gk.静态修饰符;

/**
 * Created by gaokuo on 2018/3/7.
 */
public abstract class Person {

//    静态方法是不能抽象的
//    public static abstract void sayHello();

    public static void sayHello(){
        System.out.println("person say hello");
    }

//    静态方法可以用final修饰
    public final static void sayHello1(){
        System.out.println("person say hello");
    }

}
