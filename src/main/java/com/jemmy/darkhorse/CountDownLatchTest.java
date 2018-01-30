/**
 * 
 */
package com.jemmy.darkhorse;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Administrator
 * @date 2012-3-25
 */
public class CountDownLatchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final CountDownLatch cdlOrder = new CountDownLatch(1);
		final CountDownLatch cdlAnswer = new CountDownLatch(3);
		
		for (int i = 0; i < 3; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() +
							" is ready to start");
					
					try {
						cdlOrder.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println(Thread.currentThread().getName() +
					" has got the order, start to execute the mission");
					
					try {
						Thread.sleep((long)(Math.random() * 10000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println(Thread.currentThread().getName() +
							" is ready to finish");
					cdlAnswer.countDown();
					System.out.println(Thread.currentThread().getName() +
					" has finished the task");
				}
			};
			
			service.execute(runnable);
		}
		
		service.shutdown();
		
		System.out.println(Thread.currentThread() + " is about to send order");
		cdlOrder.countDown();
		System.out.println(Thread.currentThread() + " has already sent out the order");
		
		System.out.println(Thread.currentThread() + " is waiting for the answer");
		try {
			cdlAnswer.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread() + " has got all the answers");
	}

}
