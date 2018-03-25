package com.gk.多线程.原子类atomic;

import com.gk.代理模式.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Administrator on 2018/3/10.
 */
public class TestAtomicArray {

    //数组的原子
    public static int[] a = {1,3,5,7,0};
    public static AtomicIntegerArray array = new AtomicIntegerArray(a);

    //引用
    public static AtomicReference<String> reference = new AtomicReference<String>("hello");

    //对象的字段是volatile类型
    public static AtomicIntegerFieldUpdater<Student> field = AtomicIntegerFieldUpdater.newUpdater(Student.class,"age");



    public static void main(String[] args) {

        //数组类型，数组中每个元素都是volatile类型
        int r1 =TestAtomicArray.array.incrementAndGet(0);
        System.out.println(r1);

        //引用类型，当期望值是str1时才改变str1的引用为str2
        String str1 = "hello";
        String str2 = "world";
        boolean flag = TestAtomicArray.reference.compareAndSet(str1,str2);
        System.out.println(flag+" --- "+str1);

        //对象中有字段为volatile类型，想要是此对象的字段实现原子操作
        Student stu = new Student();
        TestAtomicArray.field.compareAndSet(stu,10,100);
        System.out.println(stu.age);



    }
}
