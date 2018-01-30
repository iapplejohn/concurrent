/**
 * 
 */
package com.jemmy.darkhorse;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Administrator
 * @date 2012-4-29
 */
public class Kongzhongwang3 extends Thread{
	private String key;
	private String value;
	
	public Kongzhongwang3(String key1, String key2, String value) {
		this.key = key1 + key2;
		this.value = value;
	}

	public static void main(String[] args) {
		Kongzhongwang3 k1 = new Kongzhongwang3("1", "", "1");
		Kongzhongwang3 k2 = new Kongzhongwang3("1", "", "2");
		Kongzhongwang3 k3 = new Kongzhongwang3("3", "", "3");
		Kongzhongwang3 k4 = new Kongzhongwang3("4", "", "4");
		
		k1.start();
		k2.start();
		k3.start();
		k4.start();
	}
	
	static class Corruption {
		private Corruption() {}
		private static int i;
		private static Corruption instance;
		
		public static Corruption getInstance() {
			if (instance == null) {
				synchronized (Corruption.class) {
					if (instance == null) {
						instance = new Corruption();
						System.out.println(i++);
					}
				}
			}
			return instance;
		}

//		ArrayList keys = new ArrayList();
		CopyOnWriteArrayList keys = new CopyOnWriteArrayList();
		public void faciliate(Object key, Object value) {
			Object o = key;
			if (!keys.contains(o)) {
				keys.add(o);
			} else {
				for (Iterator iter = keys.iterator(); iter.hasNext();) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Object obj = iter.next();
					if (obj.equals(key)) {
						o = obj;
						break;
					}
				}
			}
			synchronized (o) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(key + ":" + value + ":" + System.currentTimeMillis() / 1000);
			}
		}
	}

	@Override
	public void run() {
//		while (true) {
			Corruption.getInstance().faciliate(this.key, this.value);
//		}
	}
}
