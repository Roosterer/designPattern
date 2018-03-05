package com.gk.类加载器;

import com.gk.StringUtils;
import com.gk.代理模式.CGLIB动态代理.PersonImp;
import sun.misc.Launcher;

import java.math.BigDecimal;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 * Created by gaokuo on 2018/2/28.
 */
public class TestClassLoad {
    public static void main(String[] args) throws Exception{

        //测试：4中类加载器的获取即加载器之间的上下级关系测试

        //一、开发者可获取使用的类加载器：AppClassLoader，3种方式获取同一个AppClassLoader，可根据hashcode判断
        //1. 根据calss类获取
        ClassLoader c1 = TestClassLoad.class.getClassLoader();
        //2. 使用ClassLoader类获取
        ClassLoader c2 = ClassLoader.getSystemClassLoader();
        //3. 当前程序默认的classLoad，例如tomcat是WebAppClassLoad
        ClassLoader c3 = Thread.currentThread().getContextClassLoader();
        System.out.println(c1);//输出：sun.misc.Launcher$AppClassLoader@7d05e560
        System.out.println(c2);//输出：sun.misc.Launcher$AppClassLoader@7d05e560
        System.out.println(c3);//输出：sun.misc.Launcher$AppClassLoader@7d05e560

        //二、测试AppClassLoader的上层及上上层加载器
        System.out.println("====================");

        System.out.println(c3.getParent());//输出：sun.misc.Launcher$ExtClassLoader@e1641c0
        System.out.println(c3.getParent().getParent());//输出：null
        //问题：系统类加载器-》扩展类加载器-》启动类加载器，为什么扩展类夹杂器的上层返回值为null

        //三、类加载器之间，java的对象继承关系
        System.out.println("====================");
        //1. ClassLoader为一个抽象类，所有类加载器的父类，除了启动类夹杂器
        ClassLoader classLoader = null;
        //2. Launcher的静态内部类AppClassLoader extends URLClassLoader
        //Launcher的静态内部类AppClassLoader extends URLClassLoader
        //Launcher的静态内部类ExtClassLoader extends URLClassLoader
        //由于AppClassLoader，ExtClassLoader的权限为default，所以不能直接创建实例
        classLoader = Launcher.getLauncher().getClassLoader();
        System.out.println(classLoader);
        //3. URLClassLoader是个什么呢？
        //URLClassLoader extends SecureClassLoader
        //SecureClassLoader extends ClassLoader
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{});
        //SecureClassLoader实现类加载时的安全校验，可以间接知道AppClassLoader,ExtClassLoader也都间接
        //继承了SecureClassLoader

        //四、加载类时的内部调用逻辑
        System.out.println("====================");
        Class c = classLoader.loadClass("java.lang.String");
        System.out.println(c);
    }

}
