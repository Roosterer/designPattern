package com.gk.反射;

/**
 * Created by gaokuo on 2018/3/6.
 */
public class MyPersonImp implements MyInterface {

    //测试使用的属性，公有，私有，静态，非静态
    private String prName = "private name";
    public String puName = "public name";
    private static String prsName = "private static name";
    public static String pssName = "public static name";

    //接口实现方法
    public void sayHello() {
        System.out.println("my person say hello");
    }

    //测试方法，公有，私有，有参，无参
    public void sayHello(String mes){
        System.out.println("say "+mes);
    }

    public void sayHello(String mes,Integer mes2){
        System.out.println("say "+mes+" Integer "+mes2);
    }

    //Integer,int是作为不同的参数类型，是可以进行重载的
    public void sayHello(String mes,int mes2){
        System.out.println("say "+mes+" int "+mes2);
    }

    //私有方法
    private void say(){
        System.out.println("private say yes");
    }

    public static void sayStatic(){
        System.out.println("this is a static fun invoke");
    }

}
