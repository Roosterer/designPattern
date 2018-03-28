package com.gk.集合;

import java.util.HashMap;

/**
 * Created by gaokuo on 2018/3/28.
 */
public class TestHashMap {

    public static void main(String[] args) {

        //提供的3中构造方法
        HashMap<String,String> hashMap = new HashMap<>();
        HashMap<String,String> hashMap1 = new HashMap<>(16);
        HashMap<String,String> hashMap2 = new HashMap<>(16,0.75f);

        //增加元素
        hashMap.put("key","value");
        hashMap.put("key1","value1");

        //获取元素
        hashMap.get("key");

        //删除元素
        hashMap.remove("key");



    }

}
