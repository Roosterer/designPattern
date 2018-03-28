package com.gk.jdk8新特性;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by gaokuo on 2018/3/23.
 */
public class MyTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.forEach(System.out::println);

        //过滤，得到总数
        long count = list.stream().filter(s -> s.contains("wo")).count();
        System.out.println(count);

        //过滤，倒排序，返回集合
        list = list.stream().filter(s -> s.contains("o")).sorted((s1,s2)->s2.compareTo(s1)).collect(Collectors.toList());
        list.forEach(System.out::println);


        //分组
        list = list.stream().map(s -> s.equals("hello") ? "1" : "0").distinct().collect(Collectors.toList());
        list.forEach(System.out::println);

    }

}
