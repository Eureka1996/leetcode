package com.wufuqiang.pcmodel;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: Wu Fuqiang
 * @create: 2021-04-03 16:59
 * 使用BlockingQueue实现生产者消费者模型
 */
public class PCModel3 {
    private static Integer count = 0;
    //创建一个阻塞队列
    private final BlockingQueue blockingQueue = new ArrayBlockingQueue(10);

    public static void main(String[] args) {
        PCModel3 pcModel3 = new PCModel3();
        new Thread(pcModel3.new Producer(),"生产者1").start();
        new Thread(pcModel3.new Producer(),"生产者2").start();
        new Thread(pcModel3.new Producer(),"生产者3").start();
        new Thread(pcModel3.new Producer(),"生产者4").start();
        new Thread(pcModel3.new Consumer(),"消费者1").start();
        new Thread(pcModel3.new Consumer(),"消费者2").start();
        new Thread(pcModel3.new Consumer(),"消费者3").start();
    }

    class Producer implements Runnable{

        @Override
        public void run(){
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    blockingQueue.put(1);
                    count++;
                    System.out.println(Thread.currentThread().getName()+"生产者生产，目前总共有："+count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
                try {
                    blockingQueue.take();
                    count--;
                    System.out.println(Thread.currentThread().getName()+"消费者消费，目前总共有："+count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
