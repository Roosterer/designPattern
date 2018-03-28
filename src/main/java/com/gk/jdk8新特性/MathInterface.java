package com.gk.jdk8新特性;

/**
 * Created by gaokuo on 2018/3/26.
 */
public interface MathInterface {

    int operation(int a,int b);

    default int addition(int a, int b){
        return a+b;
    }

//    int operation(int a,int b,int c);

    public static void sayHello(){
        System.out.println("hello...");
    }

}
