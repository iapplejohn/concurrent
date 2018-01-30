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
public class ConditionThreadCommunication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Derive derive = new Derive();
		// A new thread marked as main
		new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++)
					derive.main(i);
			}
		}.start();
		
		// A new thread marked as sub
		new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++)
					derive.sub(i);
			}
		}.start();

	}
	
	static class Derive {
		boolean bShouldSub = false;
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		
		public void main(int i) {
			lock.lock();
			while (bShouldSub) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			try {
				for (int j = 1; j <= 100; j++)
					System.out.println("main thread sequence of " + j
							+ " loop of " + i);
				bShouldSub = true;
				condition.signal();
			} finally {
				lock.unlock();
			}
		}
		
		public void sub(int i) {
			lock.lock();
			while (!bShouldSub) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				for (int j = 1; j <= 10; j++)
					System.out.println("sub thread sequence of " + j
							+ " loop of " + i);
				bShouldSub = false;
				condition.signal();
			} finally {
				lock.unlock();
			}
		}
	}

}
