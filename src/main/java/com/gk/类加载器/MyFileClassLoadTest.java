package com.gk.类加载器;

/**
 * Created by gaokuo on 2018/3/5.
 */
public class MyFileClassLoadTest {
    public static void main(String[] args) throws Exception{
        //1. 使用默认的loadClass
        MyFileClassLoad myFileClassLoad = new MyFileClassLoad("E:");
        Class ret1 = myFileClassLoad.loadClass("com.gk.StringUtils");
        System.out.println(ret1);

        //2. 使用自定义的findClass
        Class ret2 = myFileClassLoad.findClass("com.gk.StringUtils");
        System.out.println(ret2);
        //3. 输出hashCode，结果不同
        System.out.println(ret1.hashCode());
        System.out.println(ret2.hashCode());
        //4. 试图再使用findClass定义一个StringUtils
        //exception:loader (instance of  com/gk/类加载器/MyFileClassLoad): attempted  duplicate class definition for name: "com/gk/StringUtils"
        //说明即使是自定义的类加载器，一个类加载实例，无法加载两个相同的类
//        在JVM中表示两个class对象是否为同一个类对象存在两个必要条件
//        ● 类的完整类名必须一致，包括包名
//        ● 加载这个类的ClassLoader(指ClassLoader实例对象)必须相同
        //Class ret3 = myFileClassLoad.findClass("com.gk.StringUtils");

        //5. 重新创建一个类实例，加载类
        MyFileClassLoad myFileClassLoad2 = new MyFileClassLoad("E:");
        Class ret4 = myFileClassLoad2.findClass("com.gk.StringUtils");
        System.out.println(ret4);
        System.out.println(ret4.hashCode());
        //结论，由于loadClass中先冲缓存查找，所以使用loadClass加载一个类文件可以得到hashcode相同的class
        //使用自定义的findClass，不同的自定义类加载器实例，加载一个类文件得到不同hashcode的class，即认为它两不是同一个类



    }
}
