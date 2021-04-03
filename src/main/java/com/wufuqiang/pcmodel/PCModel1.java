package com.wufuqiang.pcmodel;

import java.util.concurrent.locks.Lock;

/**
 * @author: Wu Fuqiang
 * @create: 2021-04-03 16:08
 * 生产者和消费者，wait()和notify()的实现
 */
public class PCModel1 {

    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static Object LOCK = new Object();

    public static void main(String[] args){
        PCModel1 pcModel1 = new PCModel1();
        new Thread(pcModel1.new Producer()).start();
        new Thread(pcModel1.new Producer()).start();
        new Thread(pcModel1.new Producer()).start();
        new Thread(pcModel1.new Producer()).start();
        new Thread(pcModel1.new Consumer()).start();
        new Thread(pcModel1.new Consumer()).start();
        new Thread(pcModel1.new Consumer()).start();
        new Thread(pcModel1.new Consumer()).start();
    }

    /**
     * 生产者，每个生产者就是一个线程
     * 每一个生产者一直在生产
     */
    class Producer implements Runnable{

        @Override
        public void run() {
            //一直在生产
            while(true){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (LOCK){
                    //仓库已满，没有多余的空间了，请等待
                    while(count == FULL){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //生产
                    count++;
                    System.out.println(Thread.currentThread().getName()+"生产者生产，目前总共有："+count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK){
                    while (count == 0){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()+"消费者消费，目前总共有："+count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}
