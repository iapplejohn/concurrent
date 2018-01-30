/**
 * 
 */
package com.jemmy.basis;

import javax.swing.SwingUtilities;

/**
 * @author Administrator
 * @date 2012-12-1
 */
public class FinallyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		beely();
//		ache();
		heel();
	}
	
	private static void beely() {
		try {
			throw new Exception("Manually throw an exception");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally statement is being executed!");
		}
	}
	
	private static void ache() {
		try {
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally statement is being executed!");
		}
	}
	
	private static void heel() {
		try {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					System.exit(0);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally statement is being executed!");
		}
	}

}
