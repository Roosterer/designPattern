package com.gk.泛型;

/**
 * Created by gaokuo on 2018/2/23.
 */
public class GenericInterfaceTest {

    public static void main(String[] args) {

        GenericInterface gc1 = new GenericInterface.Sub1();
        System.out.println(gc1.getK());

        GenericInterface gc2 = new GenericInterface.Sub2();
        System.out.println(gc2.getK());

        //这里sub3虽然确定为了K,T为String类型，但是如果gc3不声明<String,String>，gc3.getK()仍返回Object类型
        GenericInterface<String,String> gc3 = new GenericInterface.Sub3("hello","world");
        System.out.println(gc3.getK());

    }

}
