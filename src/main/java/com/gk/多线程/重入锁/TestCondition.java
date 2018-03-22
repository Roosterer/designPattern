package com.gk.多线程.重入锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gaokuo on 2018/3/12.
 */
public class TestCondition {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();//同一个lock多次lock.newCondition()，condition是不同对象
    private static int var = 0;

    private static void syncFun(){
        lock.lock();
        try {
            var++;
            System.out.println(Thread.currentThread().getId()+" var is "+var);
//            condition.await();
            System.out.println(Thread.currentThread().getId()+" is sleep 3s");
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    static class ThreadA extends Thread{
        @Override
        public void run() {
            int count = 5;
            for (int i = 0; i < count; i++) {
                syncFun();
            }
        }
    }


    static class ThreadB extends Thread{
        @Override
        public void run() {
            lock.lock();
            System.out.println("ThreadB get lock,signal");
            condition.signalAll();
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new ThreadA();
        Thread t2 = new ThreadB();
        t1.start();
        Thread.sleep(1000);
        t2.start();
        t1.interrupt();


    }



}
