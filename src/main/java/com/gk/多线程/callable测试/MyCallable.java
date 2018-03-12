package com.gk.多线程.callable测试;

import java.util.concurrent.*;

/**
 * Created by gaokuo on 2018/3/8.
 */
public class MyCallable implements Callable<String> {

    public String call() throws Exception {
        System.out.println("do work start");
        Thread.sleep(1000);//正在做一些耗时的工作
        System.out.println("do work end...");
        return "i am result";
    }


    public static void main(String[] args) throws Exception{

        //使用callable的两种方式

        MyCallable mc = new MyCallable();
        ExecutorService executorService = Executors.newCachedThreadPool();

        //1. submit
        Future<String> future = executorService.submit(mc);//submit参数支持runable和callable两种类型
        System.out.println("main do other work");
        System.out.println(future.get());//future.get是一个阻塞性的方法
        System.out.println("callable work is ok");

        System.out.println("========================");
        //2.futureTask
        FutureTask<String> futureTask = new FutureTask<String>(mc);
        executorService.execute(futureTask);//execute，参数是runable类型，但是FutureTask支持callable和runalbe两种各类型
//        futureTask.run();//执行callable线程call方法，和直接调用call没有区别，是阻塞方法
        System.out.println("main do other work");
        System.out.println("isCancelled "+futureTask.isCancelled());
        System.out.println("isDone "+futureTask.isDone());
        System.out.println(futureTask.get());
        System.out.println("isDone "+futureTask.isDone());

        /*FutureTask构造方法支持runable，callable两种参数，所以可以使用Thread(FutureTask)的方式启动线程
        * 也可以使用*/


        /*总结：Callable和Runalbe的一些区别：
        * 1. callable有返回值，可在创建时根据泛型确认返回值
        * 2. callable能抛出异常，runalbe是不行的
        * 3. 启动方式不同，callable使用ExecutorService启动，当然ExecutorService支持
        * callable，runable，future作为参数
        * 4. callable是runable的补充实现，提供更多的灵活性*/

    }

}
