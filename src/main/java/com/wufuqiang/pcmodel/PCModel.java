package com.wufuqiang.pcmodel;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者和消费者模式
 *
 */
public class PCModel {

	//存储中现有的数量
	private static int count = 0;
	//存储的总大小
	private static int full = 10;
	//锁
	private Lock lock = new ReentrantLock();
	//
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();

	public static void main(String[] args) {
		PCModel test = new PCModel();
		new Thread(test.new Producter()).start();
		new Thread(test.new Producter()).start();
		new Thread(test.new Producter()).start();
		new Thread(test.new Consumer()).start();
		new Thread(test.new Consumer()).start();
//		new Thread(test.new Consumer()).start();
	}

	/**
	 * 内部类，负责生产数据
	 */
	class Producter implements Runnable{
		@Override
		public void run() {
			//持续生产
			while(true){
				//生产之前获取锁
				lock.lock();
				try{
					while(count == full){
						//已经满了，不满的判断(即生产者)都去休息
						notFull.await();
					}
					count+=1;
					System.out.println(Thread.currentThread().getName()
							+ "生产者生产，目前总共有" + count);
					notEmpty.signal();
				}catch(Exception e){

				}finally {
					//生产完成后释放锁
					lock.unlock();
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class Consumer implements Runnable{

		@Override
		public void run() {
			while(true){
				lock.lock();
				try{
					while(count==0){
						//已经空了，消息者都去休息
						notEmpty.await();
					}
					count-=1;
					System.out.println(Thread.currentThread().getName()
							+ "消费者消费，目前总共有" + count);
					notFull.signal();
				}catch(Exception e){

				}finally {
					lock.unlock();
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

