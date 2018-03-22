package com.gk.集合;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gaokuo on 2018/3/15.
 */
public class 循环时修改集合元素 {

    public static void main(String[] args) {

        //初始化集合
        List<Integer> myList = new ArrayList<Integer>();
        int count = 4;
        for (int i = 0; i < count; i++) {
            myList.add(i);
        }

        /*//foreach集合，同时add元素，抛出异常
        for (Integer integer : myList) {//Exception in thread "main" java.util.ConcurrentModificationException
            System.out.println(integer);
            myList.add(integer);
        }*/

        /*//fori集合，遍历时增加元素，测试ok
        int size = myList.size();
        for (int i = 0; i < size; i++) {
            System.out.println(myList.get(i));
            System.out.println("size "+myList.size());
            myList.add(myList.get(i));
            System.out.println("size "+myList.size());
        }*/


/*        //迭代器循环,同时add元素，抛出异常
        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()){
            int value = iterator.next();//Exception in thread "main" java.util.ConcurrentModificationException
            System.out.println(value);
            System.out.println("size "+myList.size());
            myList.add(value);//add会导致错误
            myList.remove(value);//remove会导致错误
            System.out.println("size "+myList.size());
        }*/

        /*Iterator<Integer> iterator = myList.iterator();
        int var = iterator.next();
        iterator.remove();//iterator提供了一个remove方法，使用这个方法可以正常移除var，前提是next()有值，而移除的就是next
        for (Integer integer : myList) {
            System.out.println(integer);
        }*/

        /*总结：
        * 1. 使用fori遍历集合时，可以自由修改集合结构（add，remove），前提是不会导致无限循环，下标越界，需要注意。
        * 2. 使用foreach遍历集合时，不能使用集合的add，reove方法修改集合结构。
        * 3. 使用迭代器遍历时，不能使用集合的add，reove方法修改集合结构,但是可以iterator.remove();删除当前游标所指的元素。
        *
        * 对于java的集合而言，public interface Collection<E> extends Iterable<E>
        * 它是实现了Iterable，而实现了Iterable接口就可以通过hasnext,next等方法去遍历集合。对于客户端而言，
        * 它不需要知道你的集合时map，list，set，只要通过迭代器就可以进行遍历。
        * foreach就是用来循环迭代器，只要实现了Iterable接口的类，都能使用foreach进行变脸，foreach的优点是
        * 使循环代码变得更加简洁。这样也就理解了为什么使用foreacn和迭代器进行循环不能修改集合结构，因为他们都是
        * 在循环迭代器，而迭代器的实现中会判断集合的版本状态，如果集合就行了修改，集合版本和迭代器版本不一致就会
        * 抛出异常，提示你这是一个非安全的操作。
        *
        * 有用的结论：
        * 1. 在遍历arrayList这类集合时，它本身是数组实现，随机访问很快，使用fori，下标访问是比较合适的
        * 2. 在遍历linkedList这类集合时，它是链表实现，对于顺序访问更快，使用迭代器进行访问（即顺序访问）比较快
        * 3. 至于使用下标还是迭代器遍历那个效率更高，要根据具体的集合结构来决定。
        *
        * */

    }



}
