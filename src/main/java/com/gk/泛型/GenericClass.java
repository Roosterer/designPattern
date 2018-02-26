package com.gk.泛型;

/**
 * Created by gaokuo on 2018/2/23.
 */

//泛型类测试代码
//T,E可以是任意的字母，2个类型待确定
public class GenericClass<T,E> {

    private T tParam;
    private E eParam;


    GenericClass(T tParam,E eParam){
        this.tParam = tParam;
        this.eParam = eParam;
    }

    public T gettParam() {
        return tParam;
    }

    public void settParam(T tParam) {
        this.tParam = tParam;
    }

    public E geteParam() {
        return eParam;
    }

    public void seteParam(E eParam) {
        this.eParam = eParam;
    }


    /**
     * main测试泛型的使用
     *
     * 1. 使用泛型可以在编译器确定类型转换异常
     * 2. 更灵活的使用方式，泛型可以是任意类型，可以指定多个
     * 3. 泛型类型只能是对象，不能是基本类型。像Map一样，不能讲int作为泛型类型
     */

    public static void main(String[] args) {

        //创建实例，不指定类型时默认为object类型，不能再编译期确定类型转换错误
        GenericClass gc = new GenericClass("string" , 19999);
        System.out.println(gc.gettParam());//gc.gettParam()返回的是Object类型
        System.out.println((String)gc.geteParam());//报错，类型转换异常。

        //创建实例，指定泛型类型
        GenericClass<String,Integer> gc2 = new GenericClass<String,Integer>("string" , 19999);
        System.out.println(gc2.gettParam());
//        System.out.println((String)gc2.geteParam());//编译期报错

    }
}
