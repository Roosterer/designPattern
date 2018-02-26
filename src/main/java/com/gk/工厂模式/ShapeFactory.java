package com.gk.工厂模式;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by gaokuo on 2018/2/23.
 */
public class ShapeFactory {

    /**
     * 传入参数获取实例，，但是每次新增类需要修改此工厂方法
     * @param type
     * @return
     */
    public static Shape getShape(String type){

        if("circle".equals(type)){

            return new Circle();
        }else if("square".equals(type)){

            return new Square();
        }
        return null;
    }

    /**
     *  利用反射获取，此方法基本通用，可获取T的子类实例
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getShape2(Class <? extends T> clazz){

        T obj = null;

        try {
            obj = (T)Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static Shape getShape3(Class <? extends Shape> clazz){

        Shape obj = null;

        try {
            obj = (Shape) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }


    public static void main(String[] args) throws Exception{

        Shape shape1 = ShapeFactory.getShape("circle");
        shape1.draw();

        Shape shape2 = ShapeFactory.getShape("square");
        shape2.draw();

        //泛型
        Shape s1 = ShapeFactory.getShape2(Circle.class);
        Shape s2 = ShapeFactory.getShape2(Square.class);
        s1.draw();
        s2.draw();

        //通配符
        Shape s3 = ShapeFactory.getShape3(Circle.class);
        Shape s4 = ShapeFactory.getShape3(Square.class);
        s1.draw();
        s2.draw();

    }

}
