package com.gk.反射;

/**
 * Created by gaokuo on 2018/3/6.
 */
public class TestGetSuperClass {

    public static void main(String[] args) {

        //获取class的父类
        Class c = MyPersonImp.class;
        Class sup = c.getSuperclass();
        System.out.println(sup);

    }

}
