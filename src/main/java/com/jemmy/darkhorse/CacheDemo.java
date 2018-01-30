/**
 * 
 */
package com.jemmy.darkhorse;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Administrator
 * @date 2012-3-18
 */
public class CacheDemo {
	private Map<String, Object> cache = new HashMap<String, Object>();
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	volatile Object obj = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final CacheDemo demo = new CacheDemo();
		for (int i = 0; i < 3; i++) {
			new Thread() {
				int j = 10;
				@Override
				public void run() {
					while (j-- > 0) {
						demo.getData("contrive");
					}
				}
			}.start();
		}
	
	}
	
	public Object getData(String key) {
		lock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + " is about to get the data");
			obj = cache.get(key);
			System.out.println(Thread.currentThread().getName() + " has already got the data: " + obj);
			if (obj == null) {
				lock.readLock().unlock();
				lock.writeLock().lock();
				if (obj == null) {
					System.out.println(Thread.currentThread().getName()
							+ " has to initialize the data");
					obj = "data from db";
					cache.put(key, obj);
					System.out.println(Thread.currentThread().getName()
							+ " has already initialized the data");
				}
				lock.readLock().lock();
				lock.writeLock().unlock();
			}
		} finally {
			lock.readLock().unlock();
		}
		return obj;
		
	}

}
