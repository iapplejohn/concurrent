/**
 * 
 */
package com.jemmy.enhancement;

import java.lang.reflect.Array;

/**
 * @author Administrator
 * @date 2012-4-7
 */
public class ArrayReflect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Object obj = new String[] {"entail", "huge", "political"};
//		obj = "The changed outlook entails higher economic growth than it was previously assumed";   
//		printObject(obj);
		
//		int[] ages = new int[] { 28, 27, 24 };
//		System.out.println(getType(ages));
		
		ReflectPoint[] points = new ReflectPoint[3];
		points[0] = new ReflectPoint(4, 6);
		points[1] = new ReflectPoint(3, 2);
		points[2] = new ReflectPoint(6, 8);
		System.out.println(getType(points));
	}
	
	private static Class getType(Object obj) {
		Class clazz = obj.getClass();
		return clazz.getComponentType();
	}

	// How to reflect the instance of Array
	// Utilize the java.lang.reflect.Array 
	private static void printObject(Object obj) {
		Class clazz = obj.getClass();
		if (clazz.isArray()) {
			int len = Array.getLength(obj);
			for (int i = 0; i < len; i++) {
				System.out.println(Array.get(obj, i));
			}
		} else {
			System.out.println(obj);
		}
		
	}

}
