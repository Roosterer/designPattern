package com.gk.多线程.join测试;

/**
 * Created by gaokuo on 2018/3/6.
 */
public class MyThread extends Thread {

    private String name = "default";

    MyThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        int count = 10;
        for (int i = 0; i < count; i++) {
            try {
                if(i != 0){
                    Thread.sleep(5000);
                }

                synchronized (this){
                    Thread.sleep(5000);
                    System.out.println(name+"："+i);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

}
