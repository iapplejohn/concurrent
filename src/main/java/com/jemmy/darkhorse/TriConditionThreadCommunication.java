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
public class TriConditionThreadCommunication {

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
		
		// A new thread marked as sub2
		new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++)
					derive.sub2(i);
			}
		}.start();
		
		// A new thread marked as sub3
		new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++)
					derive.sub3(i);
			}
		}.start();
		
		// A new thread marked as sub4
		new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++)
					derive.sub4(i);
			}
		}.start();

	}
	
	static class Derive {
		private int iShouldWho = 1;
		Lock lock = new ReentrantLock();
		Condition condition1 = lock.newCondition();
		Condition condition2 = lock.newCondition();
		Condition condition3 = lock.newCondition();
		Condition condition4 = lock.newCondition();
		
		public void main(int i) {
			lock.lock();
			try {
				while (iShouldWho != 1) {
					try {
						condition1.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				for (int j = 1; j <= 100; j++)
					System.out.println("main thread sequence of " + j
							+ " loop of " + i);
				iShouldWho = 2;
				condition2.signal();
			} finally {
				lock.unlock();
			}
		}
		
		public void sub2(int i) {
			lock.lock();
			try {
				while (iShouldWho != 2) {
					try {
						condition2.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				for (int j = 1; j <= 10; j++)
					System.out.println("sub2 thread sequence of " + j
							+ " loop of " + i);
				iShouldWho = 3;
				condition3.signal();
			} finally {
				lock.unlock();
			}
		}
		
		public void sub3(int i) {
			lock.lock();
			try {
				while (iShouldWho != 3) {
					try {
						condition3.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int j = 1; j <= 10; j++)
					System.out.println("sub3 thread sequence of " + j
							+ " loop of " + i);
				iShouldWho = 4;
				condition4.signal();
			} finally {
				lock.unlock();
			}
		}
		
		public void sub4(int i) {
			lock.lock();
			while (iShouldWho != 4) {
				try {
					condition4.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				for (int j = 1; j <= 10; j++)
					System.out.println("sub4 thread sequence of " + j
							+ " loop of " + i);
				iShouldWho = 1;
				condition1.signal();
			} finally {
				lock.unlock();
			}
		}
	}

}
