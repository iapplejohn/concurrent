/**
 * 
 */
package com.jemmy.enhancement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

/**
 * @author Administrator
 * @date 2012-4-7
 */
public class ArrayListVsHashSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Approach 1 - Directly by keyword new
//		Collection collection = new ArrayList();
//		Collection collection = new HashSet();
		
		// Approach 2 - By reflection
		Properties props = null;
		try {
			// Approach 1 - the jresource file is located based on the root directory
//			InputStream inputStream = new FileInputStream("src/config.properties");
			
			// Approach 2 - utilize the class loader, supposing that
			// the path of the resource has something to do with the class loader
			// The path is based on the root path of the class
//			InputStream inputStream = ArrayListVsHashSet.class.getClassLoader().getResourceAsStream("config.properties");
//			InputStream inputStream = ArrayListVsHashSet.class.getClassLoader().getResourceAsStream("com/john/enhancement/config.properties");
			
			// Approach 3 - Simply utilize the method from the class
			// The path is based on the path of the class
			// In addition, we could utilize absolute path
			InputStream inputStream = ArrayListVsHashSet.class.getResourceAsStream("../../../config.properties");
//			ArrayListVsHashSet.class.getResource("config.properties");

			props = new Properties();
			props.load(inputStream);
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String className = props.getProperty("className");
		Collection collection = null;
		try {
			collection = (Collection)Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ReflectPoint rp1 = new ReflectPoint(3, 3);
		ReflectPoint rp2 = new ReflectPoint(5, 3);
		ReflectPoint rp3 = new ReflectPoint(3, 3);
		

		
		collection.add(rp1);
		collection.add(rp2);
		collection.add(rp3);
		collection.add(rp3);
		
//		rp1.setY(7);
		
//		collection.remove(rp1);
		
		System.out.println(collection.size());
	}

}
