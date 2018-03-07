package com.gk.多线程.join测试;

/**
 * Created by gaokuo on 2018/3/6.
 */
public class MyThreadA extends Thread {

    private MyThreadB obj = null;

    MyThreadA(MyThreadB obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        int count = 10;
        for (int i = 0; i < count; i++) {
            try {
                synchronized (obj){
                    System.out.println("Thread A running，A sleep 10s");
                    Thread.sleep(10000);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

}
