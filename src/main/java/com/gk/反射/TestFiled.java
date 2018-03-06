package com.gk.反射;

import java.lang.reflect.Field;

/**
 * Created by gaokuo on 2018/3/6.
 */
public class TestFiled {

    public static void main(String[] args) throws Exception{

        Class c = MyPersonImp.class;

        //getFileds获取类和父类所有的public字段
        Field[] fs = c.getFields();
        for (Field f : fs) {
            System.out.println(f);
        }

        //getDeclaredFields获取类声明的所有公有，私有方法
        System.out.println("===============");
        Field[] dfs = c.getDeclaredFields();
        for (Field f : dfs) {
            System.out.println(f);
        }

        //获取字段，赋值输出
        System.out.println("===============");
        MyPersonImp mi = new MyPersonImp();
        Field f = c.getDeclaredField("prName");
        //打破封装  实际上setAccessible是启用和禁用访问安全检查的开关,并不是为true就能访问为false就不能访问
        //由于JDK的安全检查耗时较多.所以通过setAccessible(true)的方式关闭安全检查就可以达到提升反射速度的目的
        f.setAccessible(true);
        f.set(mi,"name is gk");
        System.out.println(f.get(mi));

    }

}
