package com.gk.静态修饰符;

/**
 * Created by gaokuo on 2018/3/7.
 */
public class Student extends Person {

//    静态方法不能被重写
//    @Override
    public static void sayHello(){
//        super.sayHello();//不能使用super，看来静态字段和方法只能使用Class.fun的方式
    }
}
