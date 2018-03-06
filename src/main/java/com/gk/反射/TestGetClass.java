package com.gk.反射;

/**
 * Created by gaokuo on 2018/3/6.
 */
public class TestGetClass {

    public static void main(String[] args) throws Exception{

        //获取class的3种方式

        Class c1 = Class.forName("com.gk.反射.MyPersonImp");
        Class c2 = MyPersonImp.class;
        Class c3 = new MyPersonImp().getClass();

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }

}
