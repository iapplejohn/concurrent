/**
 * 
 */
package com.jemmy.enhancement;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Administrator
 * @date 2012-4-29
 */
public class Coordinate {
	private int x;
	private int y;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @param args
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws IntrospectionException 
	 */
	public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IntrospectionException {
		Coordinate test = new Coordinate(3, 8);
		String propertyName = "x";
		// Approach 1 - construct the method name, and invoke the method
//		String getterName = "get" + propertyName.substring(0, 1).toUpperCase(Locale.ENGLISH) + propertyName.substring(1);
//		String setterName = "set" + propertyName.substring(0, 1).toUpperCase(Locale.ENGLISH) + propertyName.substring(1);
//		Method getter = test.getClass().getDeclaredMethod(getterName);
//		Method setter = test.getClass().getDeclaredMethod(setterName, int.class);
//		Object retVal = getter.invoke(test);
//		System.out.println(retVal);
//		System.out.println(setter);
		
		// Approach 2 - java.beans.PropertyDescriptor
		Coordinate coordinate = new Coordinate(3, 8);
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, coordinate.getClass());
		Method getter = pd.getReadMethod();
		Object retVal = getter.invoke(coordinate);
		System.out.println(retVal); // 3

		Method setter = pd.getWriteMethod();
		setter.invoke(coordinate, 4);
		System.out.println(coordinate.getX()); // 4

	}


}
