package com.wufuqiang.singleton;

/**
 * @author: Wu Fuqiang
 * @create: 2021-04-03 18:38
 */
public class Singleton1 {

    // 双重检查加锁需要加volatile
    private static volatile Singleton1 instance = null;

    //私有构造器
    private Singleton1(){}

    //1、适用于单线程环境（不推荐）
    public static Singleton1 getInstanceA(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }

    //2、适用于多线程环境，但效率不高（不推荐）
    public static synchronized Singleton1 getInstanceB(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }

    //3、双重检查加锁（推荐）
    public static Singleton1 getInstanceC(){
        // 先判断实例是否存在，若不存在再对类对象进行加锁处理
        // instance要加volatile
        if(instance == null){
            synchronized (Singleton1.class){
                if(instance == null){
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

    }
}
