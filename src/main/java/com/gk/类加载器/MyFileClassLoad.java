package com.gk.类加载器;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by gaokuo on 2018/3/5.
 */

//自定义文件路径，加载类文件，自定义类加载器实现
public class MyFileClassLoad extends ClassLoader {

    //实例化后制定加载路径
    private String rootDir;
    public MyFileClassLoad(String rootDir){
        this.rootDir = rootDir;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
    /**
     * 重写查找类文件方法
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("#####gk：findClass（）");
        //1. 根据文件名及路径加载文件流，获取字节数组
        byte[] data = getBytes(name);
        if(data == null){
            throw new ClassNotFoundException();
        }
        //2. 定义类
        return super.defineClass(name,data,0,data.length);
    }

    //读取文件
    private byte[] getBytes(String name) {
        FileInputStream input = null;
        ByteArrayOutputStream out = null;
        byte[] result = null;
       try {
           //获取文件全路径及文件名称
           String filePath = rootDir + File.separatorChar +
                   name.replace('.',File.separatorChar)+".class";

           input= new FileInputStream(filePath);
           out = new ByteArrayOutputStream();
           byte[] buff = new byte[2048];
           int len = 0;
           while ((len = input.read(buff)) != -1){
               out.write(buff,0,len);
           }
           result = out.toByteArray();
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           try {
               input.close();
               out.close();
           }catch (Exception e){
               e.printStackTrace();
           }
       }
        return result;
    }
}
