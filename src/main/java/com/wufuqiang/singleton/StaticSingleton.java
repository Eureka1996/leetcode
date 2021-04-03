package com.wufuqiang.singleton;

/**
 * @author: Wu Fuqiang
 * @create: 2021-04-03 19:10
 * 通过静态内部类实现单例模式
 */
public class StaticSingleton {

    //私有构造器，禁止在其他类中创建实例
    private StaticSingleton(){}

    public static StaticSingleton getInstance(){
        return StaticSingletonHolder.instance;
    }

    public void methodA(){}

    public void methodB(){}

    public static void main(String[] args) {

    }

    private static class StaticSingletonHolder{
        private static final StaticSingleton instance = new StaticSingleton();
    }
}
