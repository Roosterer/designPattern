package com.gk.多线程.waitNotify生产消费者;

/**
 * Created by gaokuo on 2018/3/7.
 */
public class MyFactory {

    private static int maxproduct = 5;
    private static int minproduct = 0;
    private static int currp = 0;
    private static Object monitor = new Object();


    static class Producer extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                    synchronized (monitor){
                        if(currp < maxproduct){
                            currp++;
                            System.out.println(Thread.currentThread().getId()+"-Producer ++ NUM："+currp);
                        }else{
                            System.out.println(Thread.currentThread().getId()+"-Producer wait NUM："+currp);
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }


    static class Consumer extends Thread{

        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                    synchronized (monitor){
                        if(currp > minproduct){
                            currp--;
                            System.out.println(Thread.currentThread().getId()+"-Consumer -- NUM："+currp);
                        }else{
                            System.out.println(Thread.currentThread().getId()+"-Consumer wait NUM："+currp);
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }


    public void start(){
        Thread p1 = new Producer();
        Thread p2 = new Producer();
        Thread p3 = new Producer();

        Thread c1 = new Consumer();
        Thread c2 = new Consumer();

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
    }


    public static void main(String[] args) {
        //生产者消费者模型测试，不使用wait和notify的实现方式
        new MyFactory().start();
    }


}
