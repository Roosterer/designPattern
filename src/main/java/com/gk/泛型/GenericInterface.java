package com.gk.泛型;

/**
 * Created by gaokuo on 2018/2/23.
 */

//泛型接口测试代码
//泛型参数可以是多个
public interface GenericInterface<T,K> {

    T getT();
    K getK();

    //下面使用内部类的方式，来实现泛型接口

    //直接继承泛型接口，如果不指定泛型类型，类中使用到的泛型默认都为Object
    class Sub1 implements GenericInterface{

        public Object getT() {
            return null;
        }

        public Object getK() {
            return null;
        }
    }


    //Sub2在实现泛型接口时仍未确定泛型类型，Sub2<T,K>也要泛型话，否则编译器报错
    class Sub2<T,K> implements GenericInterface<T,K>{

        public T getT() {
            return null;
        }

        public K getK() {
            return null;
        }
    }

    //Sub3在实现泛型接时确定泛型类型，Sub3就不用泛型化了。比较Sub2和Sub3能很容易得出结论
    class Sub3 implements GenericInterface<String,String>{
        private String t;
        private String k;

        Sub3(String t,String k){
            this.t = t;
            this.k = k;
        }

        public String getT() {
            return this.t;
        }

        public String getK() {
            return this.k;
        }
    }

}

