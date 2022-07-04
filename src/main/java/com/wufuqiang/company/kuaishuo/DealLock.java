package com.wufuqiang.company.kuaishuo;

/**
 * 死锁
 */
public class DealLock {
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	public static void main(String[] args) {
		new Thread(new Runnable(){
			@Override
			public void run(){
				synchronized(lock1){
					try{
						Thread.sleep(300);
					}catch(Exception e){

					}
					System.out.println(Thread.currentThread().getName()+"获取第一把锁");
					synchronized(lock2){
						System.out.println(Thread.currentThread().getName()+"获取第二把锁");
					}
				}

			}
		}).start();
		new Thread(new Runnable(){
			@Override
			public void run(){
				synchronized(lock2){
					try{
						Thread.sleep(300);
					}catch(Exception e){

					}

					System.out.println(Thread.currentThread().getName()+"获取第一把锁");
					synchronized(lock1){
						System.out.println(Thread.currentThread().getName()+"获取第二把锁");
					}
				}

			}
		}).start();
	}
}
