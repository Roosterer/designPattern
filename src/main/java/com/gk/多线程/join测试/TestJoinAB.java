package com.gk.多线程.join测试;

/**
 * Created by gaokuo on 2018/3/7.
 */
public class TestJoinAB {

    public static void main(String[] args) throws Exception{

        MyThreadB b = new MyThreadB();
        MyThreadA a = new MyThreadA(b);

        a.start();
        b.start();
        System.out.println("1============");
        /*理论上，b.josn 300，b线程自己并没有做同步处理，a启动后占用了b对象10s
        * b执行完300ms后，main线程应该继续执行，但是根据结果来看，b对象的锁被a占用了10s
        * 所以导致main线程按不到b的锁，一直在竞争中，10s后才有可能拿到锁继续执行。
        * 重结果上看，b不止执行了300ms，而main一直处于阻塞中。
        *
        * 结论：在A线程中调用B线程的B.join测试(100)，A线程会等待B执行100，然后去争取B的对象锁
        * 如果拿到，则A继续执行，如果A没有拿到B的锁，则只能继续竞争B锁。注意：B线程执行死亡并不代表
        * 锁被释放。
        * */
        b.join(300);
        System.out.println("2============");

    }

}
