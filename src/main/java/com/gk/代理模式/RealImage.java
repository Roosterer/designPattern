package com.gk.代理模式;

/**
 * Created by gaokuo on 2018/2/26.
 */
public class RealImage implements Image {

    private String fileName;

    RealImage(String fileName){
        this.fileName = fileName;
    }

    public void display() {
        System.out.println("dispaly image:"+fileName);
    }

    private void loadFile(){
        System.out.println("load file:"+fileName);
    }
}
