package com.gk.多线程.容器类;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by gaokuo on 2018/3/14.
 */
public class TestBlockingQueue {
    public static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);

    static class ThreadA extends Thread {
        @Override
        public void run() {
            int i = 100;
            while (true) {
                try {
                    Thread.sleep(3000);
                    queue.offer(i--);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("get " + queue.take());//take是阻塞方法，取不到数据时阻塞
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();

    }

}
