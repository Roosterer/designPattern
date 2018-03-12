package com.gk.多线程.threadLoacl类型测试;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gaokuo on 2018/3/9.
 */
public class MyThread implements Runnable{
    ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public void run() {
        int tm = 5;
        for (int i = 0; i < tm; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set(i+"");
            System.out.println(Thread.currentThread().getId()+" -- tl is "+threadLocal.get());
            threadLocal.remove();
        }
    }

    public static void main(String[] args) {
        new Thread(new MyThread()).start();
        new Thread(new MyThread()).start();

        /*常用的ThreadLocal的3个方法，get,set,remove
        * 逻辑部分：
        * public void set(T value) {
        解释：获取当前线程
        Thread t = Thread.currentThread();
        解释：获取到当前相乘的ThreadLocalMap变量，这个ThreadLocalMap变量是
        ThreadLocal下的default内部类，因为和Thread是同一个包，所以Thread能使用这个类
        ThreadLocalMap map = getMap(t);
        if (map != null)
        解释：把ThreadLocal变量当做key存储在map中
            map.set(this, value);
        else
            createMap(t, value);
        }

        总结：每个Thread都有一个自己的ThreadLocalMap变量，给ThreadLocal var赋值，则使用ThreadLocalMap以
        var作为key，，这样相当于每个线程里都有一个私有的var，所以才不会互相影响。

        */
    }
}
