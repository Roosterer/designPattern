package com.gk.多线程.线程池管理类;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gaokuo on 2018/3/14.
 */
public class TestManager {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();//ThreadPoolExecutor
        executor = Executors.newCachedThreadPool();//ThreadPoolExecutor
        executor = Executors.newFixedThreadPool(3);//ThreadPoolExecutor
        executor = Executors.newScheduledThreadPool(3);//ScheduledThreadPoolExecutor

        executor.execute(new Runnable() {
            public void run() {
                System.out.println("i am start run");
                try {
                    Thread.sleep(2000);
                    System.out.println("i am run ok");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("ready shutdown");
        executor.shutdown();//等待线程执行完成，关闭线程池
        System.out.println("shutdown ok");

    }

}
