package com.gk.多线程.重入锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gaokuo on 2018/3/12.
 */
public class TestLock {

    private static ReentrantLock lock = new ReentrantLock();
    private static int var = 0;

    /**
     * 并发自增操作
     */
    private static void fun1(){
        lock.lock();
        var++;
        System.out.println(Thread.currentThread().getId()+" var is "+var);
        lock.unlock();
    }


    private static void fun2(){
        lock.lock();
        System.out.println(Thread.currentThread().getId()+" fun2 sleep 5s start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    /**
     * 执行并发操作的线程
     */
    static class ThreadA extends Thread{
        @Override
        public void run() {
            int count = 5;
            for (int i = 0; i < count; i++) {
                fun1();
//                fun2();
            }
        }
    }

    /**
     * 测试a线程执行处于阻塞状态时，lock方法能够获取到的相关信息
     */
    static class ThreadB extends Thread{
        @Override
        public void run() {
            System.out.println("getHoldCount "+lock.getHoldCount());
            System.out.println("getQueueLength "+lock.getQueueLength());
            System.out.println("hasQueuedThreads "+lock.hasQueuedThreads());
            System.out.println("isFair "+lock.isFair());
            System.out.println("isLocked "+lock.isLocked());
            System.out.println(lock.tryLock());
            try {
                System.out.println(lock.tryLock(100,TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {

        //并行执行fun1方法，能得到递增输出，lock起到了同步的作用
        new ThreadA().start();
        new ThreadA().start();
        new ThreadA().start();

    }

}
