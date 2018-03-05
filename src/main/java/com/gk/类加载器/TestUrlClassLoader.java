package com.gk.类加载器;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by gaokuo on 2018/3/5.
 */
public class TestUrlClassLoader {

    public static void main(String[] args) throws Exception{
        File file = new File("e:");
        URI uri = file.toURI();
        System.out.println(uri);
        URL url = uri.toURL();
        System.out.println(url);
        URL[] urs = new URL[]{url};
        URLClassLoader urlClassLoader = new URLClassLoader(urs);
        Object c = urlClassLoader.loadClass("com.gk.StringUtils");
        System.out.println(c.hashCode());

        URLClassLoader urlClassLoader2 = new URLClassLoader(urs);
        Object c2 = urlClassLoader2.loadClass("com.gk.StringUtils");
        System.out.println(c2.hashCode());
        //c c2 有相同的hashcode，所以是肯定是同一个类加载器加载的

        System.out.println("===================");
        System.out.println(urlClassLoader.hashCode());
        System.out.println(urlClassLoader2.hashCode());

        //之所以类加载器不同，但是加载同一个文件能得到相同的class，是因为，urlClassLoader的loadClass调用的
        //是父类ClassLoad的loadClass方法，先判断缓存，然后找父类加载器加载。理论是来说这是两个不同的类加载器
        //如果缓存是保存再每个实例中，显然，这样加载会得到不同的class，所以我判断这是一个公共缓存。fuck，不清楚
        //TODO ? 问题
    }

}
