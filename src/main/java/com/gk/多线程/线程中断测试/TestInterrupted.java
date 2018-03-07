package com.gk.多线程.线程中断测试;

/**
 * Created by gaokuo on 2018/3/7.
 */
public class TestInterrupted {

    static class ThreadA extends Thread{
        @Override
        public void run() {
            while(true){
                try {
                    if(currentThread().isInterrupted()){
                        System.out.println("is interrupted");
                    }else{
                        System.out.println("is running");
                    }
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("exception isInterrupted "+this.isInterrupted());
                }
            }

        }
    }

    public static void main(String[] args) throws Exception{

        /*发送中断到t1.interrupt(); 此时currentThread().isInterrupted()为true
        * 当t1接收到中断并抛出异常后，currentThread().isInterrupted()为true*/
        ThreadA t1 = new ThreadA();
        t1.start();
        Thread.sleep(1000);
        System.out.println("=====sleep ok=====");
        t1.interrupt();
        /*
        可接收中断并抛出InterruptedException异常的方法
        * Thread.sleep(10);
          this.wait();
          this.join();
        * */

        //建议，在一个线程的while中，通过共享变量flag的true，false作为while循环条件，可控制线程的结束
        //Thread.stop()是不建议使用的，容易引发程序异常。
    }
}
