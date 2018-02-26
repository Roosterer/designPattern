package com.gk.代理模式;

/**
 * Created by gaokuo on 2018/2/26.
 */
public class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    ProxyImage(String fileName){
        this.fileName = fileName;
        realImage = new RealImage(fileName);
    }

    public void display() {

        System.out.println("proxy display start");
        realImage.display();
        System.out.println("proxy display end");
    }
}
