/**
 * 
 */
package com.jemmy.interview;

/**
 * @author Administrator
 * @date 2012-5-7
 */
public class HengtianSoft {
	// Question 10 - jdk 1.5 enhancement - foreach simplification
	public static void main2(String[] args) {
//		ArrayList list = new ArrayList();
//		list.add(3);
//		list.add(4);
//		for (Integer i : list)
//			System.out.println(i);
	}
	
	// Question 10 - jdk 1.5 enhancement - varying parameters
	public static void main3(String[] args) {
		System.out.println(varyingParams(1, 2, 3, 4));
	}
	
	public static int varyingParams(Integer... numbers) {
		int nSum = 0;
		for (int i : numbers)
			nSum += i;
		
		return nSum;
	}
	
	// Question 10 - jdk 1.5 enhancement - printf function
	public static void main(String[] args) {
		int x = 4;
		int y = 4;
		int nSum = x + y;
		System.out.println(x + " + " + y + " = " + nSum);
		System.out.printf("%d + %d = %d\n", x, y, nSum);
		System.out.printf("%018d + %03d = %2d\n", x, y, nSum);
	}
}
