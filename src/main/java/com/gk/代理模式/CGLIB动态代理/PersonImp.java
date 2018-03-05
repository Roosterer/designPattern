package com.gk.代理模式.CGLIB动态代理;

/**
 * Created by gaokuo on 2018/2/28.
 */
public class PersonImp {

    public String name = "defaltName";

//    PersonImp(String name){
//        this.name = name;
//    }

    public PersonImp(){}

    public void sayHello(){
        System.out.println(name+" say hello...");
    }
}
