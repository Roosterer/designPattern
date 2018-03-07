package com.gk.多线程.join测试;

/**
 * Created by gaokuo on 2018/3/6.
 */
public class MyThreadB extends Thread {

    @Override
    public void run() {
        int count = 10;
        for (int i = 0; i < count; i++) {
            try {
                System.out.println("Thread B running");
                Thread.sleep(50);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

}
