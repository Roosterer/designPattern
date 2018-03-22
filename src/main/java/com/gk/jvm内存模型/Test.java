package com.gk.jvm内存模型;

/**
 * Created by gaokuo on 2018/3/15.
 */
public class Test {
    public static int i=1;

    public final int var = 100;

    public static void fun(){
        i++;
        System.out.println("num is "+i);
        fun();
    }

    public static void main(String[] args) {

        new Test().fun();
    }

}
