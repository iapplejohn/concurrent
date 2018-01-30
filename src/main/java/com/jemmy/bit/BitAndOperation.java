/**
 * 
 */
package com.jemmy.bit;

/**
 * @author Administrator
 * @date 2013-1-12
 */
public class BitAndOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int len = 2 ^ 3; // Or else
//		System.out.println(len);
		
		// Test length and operation
		// head = 0, 1
		int head = 0;
		int length = 2 << 3;
		// The below operation will get the result: (length - 1)
		// if head is equal to 0
//		System.out.println(head - 1 & length - 1);
		
		// tail = length - 1, 0
		int tail = 0;
		System.out.println(tail + 1 & length - 1);
		
	}

}
