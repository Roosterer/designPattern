package com.gk.泛型;

import javax.swing.event.TreeWillExpandListener;

/**
 * Created by gaokuo on 2018/2/23.
 */

//通配符测试
public class WildCard<T> {


    //方法参数为WildCard<Number>类型，如果传的是WildCard<Integer>类型呢？
    static void fun1(WildCard<Number> param){
        System.out.println(param);
    }

    //WildCard<?> ?匹配任意类型
    static void fun2(WildCard<?> param){
        System.out.println(param);
    }

    //WildCard<? extends Number> 匹配Number及其子类
    static void fun3(WildCard<? extends Number> param){
        System.out.println(param);
    }

    //WildCard<? extends Number> 匹配GenericInterface及其子类
    static void fun4(WildCard<? extends GenericInterface> param){
        System.out.println(param);
    }

    public static void main(String[] args) {

        WildCard<Integer> pi = new WildCard<Integer>();
        WildCard<Number> pn = new WildCard<Number>();
        WildCard<String> ps = new WildCard<String>();

        //测试fun1，只能传入WildCard<Number>类型参数
        // WildCard.fun1(pi);//无法通过编译
        WildCard.fun1(pn);

        //测试fun2，能传入任意类型参数
        WildCard.fun2(pi);
        WildCard.fun2(pn);
        WildCard.fun2(ps);

        //测试fun3，能传入匹配Number及其子类，String不行
        WildCard.fun3(pi);
        WildCard.fun3(pn);
        //WildCard.fun3(ps);////无法通过编译

        //问题，接口的实现类是否能用<? extends Interface>呢？
        //答案是没有问题的，这里的?可以代表Interface的实现类类型
        WildCard<GenericInterface> pii1 = new WildCard<GenericInterface>();
        WildCard<GenericInterface.Sub1> pii2 = new WildCard<GenericInterface.Sub1>();
        WildCard<GenericInterface.Sub2> pii3 = new WildCard<GenericInterface.Sub2>();
        WildCard.fun4(pii1);
        WildCard.fun4(pii2);
        WildCard.fun4(pii3);

    }

}
