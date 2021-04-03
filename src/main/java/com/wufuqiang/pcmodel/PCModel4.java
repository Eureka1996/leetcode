package com.wufuqiang.pcmodel;

import java.util.concurrent.Semaphore;

/**
 * @author: Wu Fuqiang
 * @create: 2021-04-03 17:26
 * 使用semaphore信号量实现生产者消费者
 */
public class PCModel4 {

    private static Integer count = 0;
    //创建三个信号量
    private final Semaphore notFull = new Semaphore(10);
    private final Semaphore notEmpty = new Semaphore(0);
    private final Semaphore mutex = new Semaphore(1);

    public static void main(String[] args) {
        PCModel4 pcModel = new PCModel4();
        new Thread(pcModel.new Producer(),"生产者1").start();
        new Thread(pcModel.new Producer(),"生产者2").start();
        new Thread(pcModel.new Producer(),"生产者3").start();
        new Thread(pcModel.new Producer(),"生产者4").start();
        new Thread(pcModel.new Consumer(),"消费者1").start();
        new Thread(pcModel.new Consumer(),"消费者2").start();
        new Thread(pcModel.new Consumer(),"消费者3").start();

    }

    class Producer implements Runnable{

        @Override
        public void run() {
            while (true){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    notFull.acquire();
                    mutex.acquire();
                    count++;
                    System.out.println(Thread.currentThread().getName()+"生产者生产，目前总共有"+count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    mutex.release();
                    notEmpty.release();
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
                    notEmpty.acquire();
                    mutex.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName()+"消费者消费，目前总共有："+count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    mutex.release();
                    notFull.release();
                }

            }
        }
    }
}
