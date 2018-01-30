/**
 * 
 */
package com.jemmy.enhancement;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Administrator
 * @date 2012-3-25
 */
public class ReflectTest23 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (String str : args)
			System.out.println(str);
	}
}

class Circumstances {
	public static void main(String[] args) {
//		ReflectTest23.main(new String[] {"curly", "bracket", "Fortune"} );
		String className = "com.john.enhancement.ReflectTest23";
		try {
			Method method = Class.forName(className).getMethod("main", String[].class);
//			method.invoke(null, (Object)new String[] {"curly", "bracket", "Fortune"});
			method.invoke(null, new Object[] { new String[] {"curly", "bracket", "Fortune"}});
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
