package com.gk.多线程.yield使用;

/**
 * Created by gaokuo on 2018/3/6.
 */
public class MyThreadYield extends Thread {

    @Override
    public void run() {
        int count = 10;
        for (int i = 0; i < count; i++) {
            try {
                System.out.println("Thread Yield running，sleep 50ms");
                Thread.sleep(50);
                /*yield的作用是，当前正执行的线程，放弃cpu执行时间，给其它线程执行机会
                * 进入runable状态，但是不排除它扔抢占到cpu执行时间继续执行，这样做的目的
                * 只是尽可能把资源分享出去*/
                Thread.yield();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
