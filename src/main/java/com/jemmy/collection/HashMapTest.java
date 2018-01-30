/**
 * 
 */
package com.jemmy.collection;

import java.util.HashMap;

/**
 * @author Administrator
 * @date 2012-4-8
 */
public class HashMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Test hash function
//		System.out.println(hash(128));
//		System.out.println(128 ^ (128 >>> 20) ^ (128 >>> 12));
		
		// Test null key and null value
		HashMap map = new HashMap(16, 0.75f);
		map.put(null, "supplemental");
		map.put(null, "insurance");
		map.put(null, null);
		map.put("probably", null);
		System.out.println(map.containsKey(null));
		System.out.println(map.size());
//		System.out.println(map.get(null));
		
		// Test indexFor function
//		map.put(123456, "extra");
//		map.put(33443436, "slightly");
//		map.put("pressure", "certification");
//		int h = hash(6666666);
//		System.out.println(h);
//		System.out.println(map.size());
//		System.out.println(indexFor(21, map.size()));
	}

	private static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
	}
	
	private static int indexFor(int hash, int length) {
		return hash & (length - 1);
	}
}
