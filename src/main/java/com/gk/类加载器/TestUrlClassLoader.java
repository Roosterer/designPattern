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
        System.out.println(c);
    }

}
