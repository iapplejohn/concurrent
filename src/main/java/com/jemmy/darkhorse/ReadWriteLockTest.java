/**
 * 
 */
package com.jemmy.darkhorse;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Administrator
 *
 */
public class ReadWriteLockTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Striver striver = new Striver();
		for (int i = 0; i < 3; i++) {
			new Thread() {

				@Override
				public void run() {
					while (true) {
						striver.get();
					}
				}
			}.start();
			
			new Thread(){
				@Override
				public void run() {
					while (true) {
						striver.put((long)(Math.random() * 1000));
					}
				}
			}.start();
		}
	}
	
	static class Striver {
		private Object data = null;
		private ReadWriteLock lock = new ReentrantReadWriteLock();
		public void get() {
			lock.readLock().lock();
			try {
				System.out.println(Thread.currentThread().getName() + " is about to get the data");
				Thread.sleep((long)(Math.random() * 1000));
				System.out.println(Thread.currentThread().getName() + " has already got the data: " + data);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				lock.readLock().unlock();
			}
		}
		
		public void put(Object data) {
			lock.writeLock().lock();
			try {
				System.out.println(Thread.currentThread().getName() + " is about to write the data");
				Thread.sleep((long)(Math.random() * 1000));
				this.data = data;
				System.out.println(Thread.currentThread().getName() + " has already written the data: " + data);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				lock.writeLock().unlock();
			}
		}
	}

}
