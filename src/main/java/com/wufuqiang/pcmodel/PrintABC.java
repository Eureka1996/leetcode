package com.wufuqiang.pcmodel;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三线程交替打印ABC
 */
public class PrintABC {
	private Lock lock = new ReentrantLock();
	private Condition printA = lock.newCondition();
	private Condition printB = lock.newCondition();
	private Condition printC = lock.newCondition();

	private boolean isA = true;
	private boolean isB = false;
	private boolean isC = false;

	public static void main(String[] args) {
		PrintABC abc = new PrintABC();
		new Thread(abc.new PrintA()).start();
		new Thread(abc.new PrintA()).start();
		new Thread(abc.new PrintA()).start();
		new Thread(abc.new PrintB()).start();
		new Thread(abc.new PrintB()).start();
		new Thread(abc.new PrintB()).start();
		new Thread(abc.new PrintB()).start();
		new Thread(abc.new PrintB()).start();
		new Thread(abc.new PrintC()).start();
		new Thread(abc.new PrintC()).start();
		new Thread(abc.new PrintC()).start();
		new Thread(abc.new PrintC()).start();
		new Thread(abc.new PrintC()).start();
		new Thread(abc.new PrintC()).start();
	}


	class PrintA implements Runnable{

		@Override
		public void run() {
			while(true){
				lock.lock();
				try{
					while(!isA){
						printA.await();
					}
					System.out.print(new String("A"));
					isA = false;
					isB = true;
					printB.signal();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	class PrintB implements Runnable{

		@Override
		public void run() {
			while(true){
				lock.lock();
				try{
					while(!isB){
						printB.await();
					}
					System.out.print(new String("B"));
					isB = false;
					isC = true;
					printC.signal();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	class PrintC implements Runnable{

		@Override
		public void run() {
			while(true){
				lock.lock();
				try{
					while(!isC){
						printC.await();
					}
					System.out.println(new String("C"));
					isC = false;
					isA = true;
					printA.signal();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
