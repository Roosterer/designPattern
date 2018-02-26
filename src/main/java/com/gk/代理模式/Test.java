package com.gk.代理模式;

/**
 * Created by gaokuo on 2018/2/26.
 */
public class Test {

    public static void main(String[] args) {
        Image image = new ProxyImage("aaa.jpg");
        image.display();
    }


}
