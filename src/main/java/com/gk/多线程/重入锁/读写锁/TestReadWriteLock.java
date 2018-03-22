package com.gk.多线程.重入锁.读写锁;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by gaokuo on 2018/3/13.
 */
public class TestReadWriteLock {

    public static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    public static int data = 0;

    public static int get(){
        rwl.readLock().lock();
        int ret = data;//模拟查询等业务操作
        rwl.readLock().unlock();
        System.out.println("====get data "+ret);
        return ret;
    }

    public static void put(){
        rwl.writeLock().lock();
        int var = (int) (Math.random()*100);
        data = var;
        System.out.println("put data "+var);
        rwl.writeLock().unlock();
    }

    public static void main(String[] args) {

        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

        /*
        结论：
        同一个线程中：获取写锁后可以通过写锁再获取读锁
        即，线程拥有了写锁，就具备了读写的权限，可以再获取读锁
        而获取读锁，再不释放读锁的情况下，不能再获取写锁

        rwl.writeLock().lock();
        System.out.println("获取写锁成功");

        rwl.readLock().lock();
        System.out.println("获取读锁成功");

        rwl.readLock().lock();
        System.out.println("获取读锁成功");

        rwl.writeLock().lock();
        System.out.println("获取写锁成功");*/


        /*通过get，put进行简单的读写测试
        * 测试逻辑：读写线程同时执行，结果，读到的数据一定是上次写入的数据
        * 而不会出现，读到的数据是上上次或更久前的数据。
        * */

        new Thread(){
            @Override
            public void run() {
                while(true){
                    TestReadWriteLock.get();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while(true){
                    TestReadWriteLock.put();
                }
            }
        }.start();


    }
}
