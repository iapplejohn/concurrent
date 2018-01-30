/**
 * 
 */
package com.jemmy.basis;

/**
 * @author John Cheng
 * @date 2012-12-15
 */
public class AssertTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		assertTest(3.0, 4.0);

	}

	private static void assertTest(double a, double b) {
		assert (a == b);
	}

}
