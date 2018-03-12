package com.gk.多线程.threadLoacl类型测试;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gaokuo on 2018/3/9.
 */
public class KengThreadLocal implements Runnable{
    public void run() {
        ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
        long[] value = new long[1024*1024*50];//1M* = 50M
        threadLocal.set(value);
        System.out.println(Thread.currentThread().getId()+"---"+threadLocal.get());
//        threadLocal.remove();//坑在这里，如果能确定，最好每次使用完都回收
    }

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        int tp = 4;
        for (int i = 0; i < tp; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Runnable t1 = new KengThreadLocal();
            executorService.execute(t1);
        }

/*      可正常执行，即使没有回收threadlocal.remove()
        int tp =4;
        for (int i = 0; i < tp; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(new KengThreadLocal()).start();
        }*/

        /*坑总结：正常来说，当线程执行完成，线程的ThreadLocalMap会被回收
        * 但是如果我们使用线程此，线程执行完成后并不会线程会依然存在，也就是ThreadLocalMap不会被回收
        * 线程还是同一个线程。这里我们使用线程池的中的同一个线程，但是每次放入线程ThreadLocalMap中的
        * 对象，也就是key（ThreadLocal变量）不是同一个，这样下去，这一个线程的map会存放很多key值。
        * 这是需要内存空间的，当key放的很多，就可能omm内存溢出。
        * 上面的例子：
        public void run() {
        ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
        long[] value = new long[1024*1024*100];//1M* = 100M
        threadLocal.set(value);
        System.out.println(threadLocal.get());
        threadLocal.remove();坑在这里
        }
        很明显，线程每次通过线程池的excute方法都会执行run方法，每次new出来的threadLocal都被放在同一个线程
        的map中，多次excute造成了内存溢出。
        解决方式：每次线程执行完就将threadLocal remove就行
        * */

    }
}
