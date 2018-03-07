package com.gk.多线程.waitNotify生产消费者;

/**
 * Created by gaokuo on 2018/3/7.
 */
public class MyFactory2 {

    private static int maxproduct = 2;
    private static int minproduct = 0;
    private static int currp = 0;
    private static Object monitor = new Object();


    static class Producer extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                synchronized (monitor){
                    if(currp < maxproduct){
                        currp++;
                        System.out.println(Thread.currentThread().getId()+"-Producer ++ NUM："+currp);
                        monitor.notifyAll();
                    }else{
                        System.out.println(Thread.currentThread().getId()+"-Producer wait before NUM："+currp);
                        monitor.wait();
                        System.out.println(Thread.currentThread().getId()+"-Producer wait after NUM："+currp);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    static class Consumer extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                synchronized (monitor){
                    if(currp > minproduct){
                        currp--;
                        System.out.println(Thread.currentThread().getId()+"-Consumer -- NUM："+currp);
                        monitor.notifyAll();
                    }else{
                        System.out.println(Thread.currentThread().getId()+"-Consumer wait before NUM："+currp);
                        monitor.wait();
                        System.out.println(Thread.currentThread().getId()+"-Consumer wait after NUM："+currp);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }


    public void start() throws Exception{
        Thread p1 = new Producer();
        Thread p2 = new Producer();
        Thread p3 = new Producer();

        Thread c1 = new Consumer();
        Thread c2 = new Consumer();

        p1.start();
        p2.start();
        p3.start();
//        p1.interrupt();
//        p1.stop();
        //等待生产者生产满额，让消费者唤醒
        Thread.sleep(1000);
        c1.start();
        c2.start();
    }


    public static void main(String[] args) throws Exception{
        /*//生产者消费者模型测试，wait,notify实现。
        * 结论：
        * 1. wait()方法后的代码将不会执行，知道拿到被唤醒拿到对象锁
        * 2. wait，notify必须再synchronized块中使用
        * 3. wait，notify，synchronizee的对象必须是同一个monitor
        * */
        new MyFactory2().start();
    }


}
