package com.gk.集合;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by gaokuo on 2018/3/28.
 */
public class TestConcurrentHashMap {

    public static void main(String[] args) {

        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        ConcurrentHashMap<String,String> map1 = new ConcurrentHashMap<>(17);
        ConcurrentHashMap<String,String> map2 = new ConcurrentHashMap<>(18,0.76f);

        //增加元素
        map.put("key","value");
        map.put("key1","value1");

        //获取元素
        map.get("key");

        //删除元素
        map.remove("key");



    }
}
