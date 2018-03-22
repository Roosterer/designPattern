package com.gk.jvm内存模型;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaokuo on 2018/3/22.
 */

//定时消耗内存，通过jmx查看相关情况
public class RunThread implements Runnable{


    public void run() {
        Map<Integer,Object> map = new HashMap<Integer, Object>();
        try {
            int count =100000;
            for (int i = 0; i < count; i++) {
                Thread.sleep(100);
                long[] arr1 = new long[100000];
                map.put(i,arr1);
                System.out.println("count === "+i);
            }
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Thread(new RunThread()).start();
    }

}
