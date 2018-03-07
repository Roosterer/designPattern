package com.gk.多线程.join测试;

/**
 * Created by gaokuo on 2018/3/6.
 */
public class TestJoin {

    public static void main(String[] args) throws Exception{

        Thread t1 = new MyThread("first");
        Thread t2 = new MyThread("secont");

        t1.start();
        System.out.println("1============");
        /*join测试 300，理论上300ms后main线程继续执行，如果main线程拿不到t1对象锁，仍然需要等待
        * */
        t1.join(300);
        System.out.println("2============");
        t2.start();//t2一旦start，t2的执行并不收到t1锁的影响
        System.out.println("3============");

        /*
          我的结论：
        * 1. t1.join测试(300); 调用者为main线程，main线程会等待t1执行300，然后进入争夺t1对象锁的过程。
        * 如果t1的锁被占用，main线程会等待并抢占t1锁，如果抢到，则能继续执行线程
        *
        * 2. t2一旦被start，它的执行并不受t1锁的影响
        *
        * 3. t1线程一旦执行完成死亡，再调用t1.join测试()不会阻塞main线程
        *
        * 4. 线程一旦死亡，不能再被重新start
        * */


    }

}
