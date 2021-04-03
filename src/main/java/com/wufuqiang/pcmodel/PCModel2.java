package com.wufuqiang.pcmodel;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Wu Fuqiang
 * @create: 2021-04-03 16:34
 * 生产者和消费者，ReentrantLock的实现
 */
public class PCModel2 {
    private static Integer count = 0;
    private static final Integer FULL = 10;
    //创建一个锁对象
    private Lock lock = new ReentrantLock();
    //创建两个条件变量，一个为缓冲区非满，一个为缓冲区非空
    //如果仓库已经满了，则将生产者放入到非满等待队列中，等待被唤醒
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();


    public static void main(String[] args){
        PCModel2 pcModel2 = new PCModel2();

        new Thread(pcModel2.new Producer(),"生产者1").start();
        new Thread(pcModel2.new Producer(),"生产者2").start();
        new Thread(pcModel2.new Producer(),"生产者3").start();
        new Thread(pcModel2.new Producer(),"生产者4").start();
        new Thread(pcModel2.new Consumer(),"消费者1").start();
        new Thread(pcModel2.new Consumer(),"消费者2").start();
        new Thread(pcModel2.new Consumer(),"消费者3").start();
        new Thread(pcModel2.new Consumer(),"消费者4").start();
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
                lock.lock();
                try{
                    while(count == FULL){
                        notFull.await();
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()+"生产者生产，目前总共有："+count);
                    notEmpty.signal();
                }catch (Exception e){
                    e.printStackTrace();
                }finally{
                    lock.unlock();
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
                lock.lock();
                try{
                    while (count == 0){
                        notEmpty.await();
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()+"消费者消费，目前总共有："+count);
                    notFull.signal();
                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }
        }
    }


}
