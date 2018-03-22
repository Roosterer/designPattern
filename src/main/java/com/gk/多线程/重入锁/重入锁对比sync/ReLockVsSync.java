package com.gk.多线程.重入锁.重入锁对比sync;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gaokuo on 2018/3/13.
 */
public class ReLockVsSync {
    public static int threadNum = 200;//线程数量
    public static int count = 10000;//执行次数
    public static ReentrantLock lock = new ReentrantLock();

    public static long startTm = 0;

    public static synchronized void lockFun(){
        //执行计算服务
        long endTm = System.currentTimeMillis();
        System.out.println("===start=== "+startTm);
        System.out.println("==end=== "+endTm);
        System.out.println("==use=== "+(endTm-startTm));
        //完成
    }

    public static void lockFun2(){
        //执行计算服务
        lock.lock();
        long endTm = System.currentTimeMillis();
        System.out.println("===start=== "+startTm);
        System.out.println("==end=== "+endTm);
        System.out.println("==use=== "+(endTm-startTm));
        lock.unlock();
        //完成
    }


    public static void main(String[] args) {

        /*创建N个线程，重复调用有sync和lock加锁的代码块，比较执行指定次数count的时间
        * 结论：可能是由于线程数或调用次数的关系，200万次的调用并没有显示出synchronized和lock的差距
        * */
        startTm = System.currentTimeMillis();

        for (int i = 0; i < threadNum; i++) {
            new Thread(){
                @Override
                public void run() {
                    for (int i1 = 0; i1 < count; i1++) {
                        lockFun();//平均执行28s
//                        lockFun2();//平均也执行28s
                    }
                }
            }.start();
        }
    }

}
