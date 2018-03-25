package com.gk.多线程.原子类atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/3/10.
 */
public class TestAtomicBase {

    //基本类型，boolean，interger，long测试
    public static AtomicInteger var = new AtomicInteger();

    //var++测试线程
    static class MyThread extends Thread{
        @Override
        public void run() {
            int count = 10;
            for (int i = 0; i < count; i++) {

                //递增同步测试
                int ret = var.incrementAndGet();
                System.out.println("递增结果---"+ret);

                //赋值安全测试，赋值失败flag返回false
                boolean flag = var.compareAndSet(ret,0);
                System.out.println("安全赋值---"+flag);
            }
        }
    }

    public static void main(String[] args) {

        //多线程 var++ 测试安全递增
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();

    }
}
