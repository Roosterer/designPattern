package com.gk.代理模式.JDK动态代理;

/**
 * Created by gaokuo on 2018/2/27.
 */
public class StudentImp implements Student {
    private String name;
    StudentImp(String name){
        this.name = name;
    }
    public void sayHello() {
        System.out.println(name+" say hello...");
    }
}
