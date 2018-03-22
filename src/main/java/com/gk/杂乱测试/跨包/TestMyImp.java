package com.gk.杂乱测试.跨包;

import com.gk.杂乱测试.MyInterface;
import com.gk.杂乱测试.MyImp;

/**
 * Created by gaokuo on 2018/3/12.
 */
public class TestMyImp {

    public static void main(String[] args) {

        MyInterface i = new MyImp();
        System.out.println(i.get1());

    }
}
