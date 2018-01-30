/**
 * 
 */
package com.jemmy.darkhorse;

import java.util.concurrent.Semaphore;

/**
 * @author Administrator
 * @date 2012-3-25
 */
public class SemaphoreTest {
	private static final int PERMITS = 3;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Semaphore semaphore = new Semaphore(PERMITS);
		for (int i = 1; i <= 10; i++) {
			new Thread() {
				public void run() {
					try {
						semaphore.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread() + " got the semaphore" +
							", " + (PERMITS - semaphore.availablePermits()) + " permits are used");
					
					try {
						Thread.sleep((long)(Math.random() * 10000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println(Thread.currentThread() + " is about the leave");
					semaphore.release();
					
					System.out.println(Thread.currentThread() + " has left, " +
							(PERMITS - semaphore.availablePermits()) + " permits are used");
				}
			}.start();
		}

	}

}
