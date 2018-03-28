package com.gk.jdk8新特性;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by gaokuo on 2018/3/26.
 */
public class TestLambda {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();
        list.add("ab");
        list.add("ac");
        list.add("bc");
        list.add("ad");

        /*
        Lambda 表达式，也可称为闭包，它是推动 Java 8 发布的最重要新特性。
        Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
        使用 Lambda 表达式可以使代码变的更加简洁紧凑。*/

        //一般实现，实现排序首先要实现Comparator接口
        int num =10;
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a = num + 10;//匿名方法的内部使用外部变量，外部变量默认是final的
                return 0;
            }
        };
        //lambda实现s1,s2是参数，如果只有一个参数()可以不加， -> 后是方法体，如果多行，用{}包含
        //如果方法体只有一行，默认可以不写return
        //1. 使用lambda表达式实现一个接口
        Comparator<String> co = (s1,s2) -> {
            int a = num + 10;//注意：方法的内部使用外部变量，外部变量默认是final的
            return s1.compareTo(s2);};
//        num++;//num被匿名方法使用，默认是final，如果出现修改num的语句，编译报错


        //2. 使用lambda作为参数
        Collections.sort(list,(s1,s2) -> s1.compareTo(s2));
        for (String s : list) {
            System.out.println(s);
        }

        //3.自定义接口，使用lambda实现接口方法
        MathInterface m1 = (s1,s2) -> s1-s2;//要使用lambda表达式，此接口只能有一个待实现接口，超过一个报错
        //但是使用default 关键字，使接口也可以有实现方法，参考MathInterface

        /*总结：
        Lambda 表达式主要用来定义行内执行的方法类型接口，例如，一个简单方法接口。
        Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力。
        * */

    }

}
