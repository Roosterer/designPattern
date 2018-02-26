package com.gk.泛型;

/**
 * Created by gaokuo on 2018/2/23.
 */

//泛型方法测试
//泛型方法：在调用方法时才确定方法参数及返回值类型的方法。
public class GenericFunction<T> {

    private T tParam;
    GenericFunction(T tParam){
        this.tParam = tParam;
    }

    //这个方法不是泛型方法，T在对象实例化时就确定了类型，而不是在调用方法时确定的
    public T gettParam() {
        return tParam;
    }

//    静态方法的泛型参数及返回值不能使用类上的泛型，下面会报错
//    public static T staticFun(T t){
//        return tParam;
//    }

    //下面演示几组真正的泛型方法
    public <T> T genericFun1(T t){
        System.out.println(t.toString());
        return t;
    }

    public <T> T genericFun2(){
        System.out.println("this is fun2");
        return (T)"ssss";
    }

    //返回值void
    public <T> void genericFun3(T t){
        System.out.println(t.toString());
    }

    //声明多个类型
    public <T,K> T genericFun4(T t,K k){
        System.out.println(t.toString()+"-"+k.toString());
        return null;
    }

    public static  <T> T genericFun5(T t){
        System.out.println(t.toString());
        return (T)new Integer(1);
    }

    //方法通配符测试
    public static  <T> T genericFun6(Class<? extends T> clazz) throws Exception{
        System.out.println(clazz.getName());
        return (T)Class.forName(clazz.getName()).newInstance();
    }


    /**
     public <T,K> T genericFun4(T t,K k){
     System.out.println(t.toString());
     System.out.println(k.toString());
     return null;
     }

     结论：
     <T,K> T
     <T,K>  声明这是一个泛型方法，且这个泛型方法有T,K两个待确认类型
     T  表示这个方法的返回值是T类型，可以使用void代替，表明没有返回值
     genericFun4(T t,K k)
     T t为参数，因为已经声明了T,K两个类型所以这里可以使用，如果使用E e则是不行的，因为没有声明
     注意：
     方法中的T和类上的T可以是同一种类型也可以不是，方法中的T不关联类上的T

     * @param args
     */


    public static void main(String[] args) throws Exception{

        GenericFunction<String> gf = new GenericFunction("hello");

        gf.genericFun1("this is fun1");
        gf.genericFun1(100);

        gf.genericFun2();

        gf.genericFun3("fun3 is now");
        gf.genericFun3(10.35);

        gf.genericFun4("hello world",1000);
        gf.genericFun4(new Object(),88888);

        GenericFunction.genericFun5("hello---yes");

        //传入的是什么类型，return强转的就是什么类型
        GenericFunction.genericFun6(GenericInterface.Sub1.class);
        GenericFunction.genericFun6(GenericInterface.Sub2.class);
        GenericFunction.genericFun6(GenericInterface.Sub3.class);//报错，return 出的newInstance构造方法需要参数

    }

}
