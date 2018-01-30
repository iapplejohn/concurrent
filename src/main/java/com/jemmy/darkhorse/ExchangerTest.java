/**
 * 
 */
package com.jemmy.darkhorse;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Administrator
 * @date 2012-3-25
 */
public class ExchangerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Exchanger exchanger = new Exchanger();
		ExecutorService service = Executors.newCachedThreadPool();
		
		service.execute(new Runnable() {
			@Override 
			public void run() {
				String data1 = "curly";
				try {
					Thread.sleep((long)(Math.random() * 10000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread() + 
						" is about to exchange " + data1);
				
				try {
					String data2 = (String)exchanger.exchange(data1);
					System.out.println(Thread.currentThread() + 
							" has exchange the " + data1 + " to " + data2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		service.execute(new Runnable() {
			@Override 
			public void run() {
				String data1 = "bracket";
				try {
					Thread.sleep((long)(Math.random() * 10000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread() + 
						" is about to exchange " + data1);
				
				try {
					String data2 = (String)exchanger.exchange(data1);
					System.out.println(Thread.currentThread() + 
							" has exchange the " + data1 + " to " + data2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		service.shutdown();
	}

}
