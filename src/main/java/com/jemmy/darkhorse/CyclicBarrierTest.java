/**
 * 
 */
package com.jemmy.darkhorse;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Administrator
 * @date 2012-3-25
 */
public class CyclicBarrierTest {
	private static final int OBJSTOSYNCHRONIZE = 3;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
//		final CyclicBarrier barrier = new CyclicBarrier(3);
		final CyclicBarrier barrier = new CyclicBarrier(OBJSTOSYNCHRONIZE, new Runnable() {
			int count = 0;
			@Override
			public void run() {
				System.out.println("Since all of you are here together, now start to achieve the " +
					++count + " station");
			}
			
		});
		
		for (int i = 0; i < 3; i++) {
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					try {
						Thread.sleep((long)(Math.random() * 10000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() +
							" is about to arrive at the first gathering place");
					try {
						barrier.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
					
					try {
						Thread.sleep((long)(Math.random() * 10000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() +
					" is about to arrive at the second gathering place");
					try {
						barrier.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
					
					try {
						Thread.sleep((long)(Math.random() * 10000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() +
					" is about to arrive at the third gathering place");
					try {
						barrier.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
				}
			};
			service.execute(runnable);
		}
		
		service.shutdown();
		
	}

}
