package com.wufuqiang.singleton;

/**
 * @author: Wu Fuqiang
 * @create: 2021-04-03 21:22
 * 饿汉式单例
 */
public class Singleton2 {
    private static final Singleton2 instance = new Singleton2();

    private Singleton2(){}

    public static Singleton2 getInstance(){
        return instance;
    }

    public static void main(String[] args) {

    }
}
