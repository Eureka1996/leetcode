package com.wufuqiang.singleton;

/**
 * @author: Wu Fuqiang
 * @create: 2021-04-03 21:27
 * 枚举类实现单例模式
 */
public class Singleton3 {
    public static void main(String[] args) {
        Single single = Single.SINGLE;
        single.print();
        Single single1 = Single.SINGLE;
        single1.print();
    }

    enum Single{
        SINGLE;

        private Single(){
            System.out.println("枚举单例");
        }

        public void print(){
            System.out.println("Hello WuFuqiang");
        }
    }
}
