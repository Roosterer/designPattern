package com.gk.反射;

/**
 * Created by gaokuo on 2018/3/6.
 */
public class TestGetInterface {

    public static void main(String[] args) {

        //获取class实现的接口class数组
        Class c = MyPersonImp.class;
        Class[] inter = c.getInterfaces();
        for (Class aClass : inter) {
            System.out.println(aClass);
        }

    }
}
