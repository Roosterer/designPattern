package com.gk.多线程.volatile测试;

/**
 * Created by gaokuo on 2018/3/8.
 */
public class VolaThread {

    //共享变量，被多个线程同时修改时，测试使用
    public static volatile int var = 0;


    static class ThreadA extends Thread {

        @Override
        public void run(){
            try {
                System.out.println("var before is "+var);
                Thread.sleep(200);
                System.out.println("var after is "+var);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadB extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(200);
                var++;
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {

        ThreadA t1 = new ThreadA();
        ThreadB t2 = new ThreadB();
        t1.start();
        t2.start();

    }



}
