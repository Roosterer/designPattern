package com.gk.多线程.重入锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gaokuo on 2018/3/13.
 */

//测试tryLock方法可被中断
public class TestTryLock {

    private static ReentrantLock lock = new ReentrantLock();

    public static void fun(){

        if(lock.tryLock()){
            System.out.println("try lock get lock");
        }else{
            System.out.println("try lock not get lock");
        }
        try {
            System.out.println("try 3s");
            if(lock.tryLock(3, TimeUnit.SECONDS)){
                System.out.println("try 3s get lock");
            }else{
                System.out.println("try 3s not get lock");
            }
        } catch (InterruptedException e) {
            System.out.println("fun is InterruptedException");
            e.printStackTrace();
        }finally {
            if(lock.getHoldCount() > 0){
                System.out.println("unlock");
                lock.unlock();
            }
        }
    }


    public static void fun2(){
        lock.lock();
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    static class ThreadA extends Thread{
        @Override
        public void run() {
            TestTryLock.fun();
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run() {
            TestTryLock.fun2();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new ThreadA();
        Thread t2 = new ThreadB();
        t2.start();
        Thread.sleep(1000);
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();

    }

}
