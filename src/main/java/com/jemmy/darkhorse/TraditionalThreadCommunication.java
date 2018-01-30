/**
 * 
 */
package com.jemmy.darkhorse;

/**
 * @author Administrator
 * @date 2012-3-18
 */
public class TraditionalThreadCommunication {

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
		public synchronized void main(int i) {
			while (bShouldSub) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 100; j++)
				System.out.println("main thread sequence of " + j + " loop of " + i);
			bShouldSub = true;
			this.notify();
		}
		
		public synchronized void sub(int i) {
			while (!bShouldSub) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 10; j++)
				System.out.println("sub thread sequence of " + j + " loop of " + i);
			bShouldSub = false;
			this.notify();
		}
	}

}
