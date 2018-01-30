/**
 * 
 */
package com.jemmy.darkhorse;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @date 2012-3-18
 */
public class BlockingQueue {
	private final static int SIZE = 10;
	private Object[] items = new Object[SIZE];
	Lock lock = new ReentrantLock();
	Condition notEmpty = lock.newCondition();
	Condition notFull = lock.newCondition();
	
	int count, putptr, takeptr;
	
	public void put(Object obj) {
		lock.lock();
		try {
			while (count == items.length) {
				try {
					notFull.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			items[putptr] = obj;
			System.out.println(Thread.currentThread() + " put the data: " + obj + " on index of " + putptr);
			if (++putptr == items.length) {
				putptr = 0;
			}

			count++;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public void get() {
		lock.lock();
		try {
			while (count == 0) {
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			Object obj = items[takeptr];
			System.out.println(Thread.currentThread() + " get the data: " + obj + " on index of " + takeptr);
			if (++takeptr == items.length) {
				takeptr = 0;
			}

			count--;
			notFull.signal();
		} finally {
			lock.unlock();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final BlockingQueue queue = new BlockingQueue();
		for (int i = 0; i < 3; i++) {
			new Thread() {
				@Override
				public void run() {
					while (true)
						queue.put(Math.random() * 1000);
				}
			}.start();

			new Thread() {
				@Override
				public void run() {
					while (true) 
						queue.get();
				}
			}.start();
		}
	}

}
