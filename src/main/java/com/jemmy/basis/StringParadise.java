/**
 * 
 */
package com.jemmy.basis;

/**
 * @author Administrator
 * @date 2012-4-29
 */
public class StringParadise {

	private String key;
	private String value;

	public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	public StringParadise(String key1, String key2, String value) {
		this.key = key1 + key2;
		this.value = value;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// String a = "1" + "paradise";
		// String b = "1" + "paradise";
		// System.out.println(a == b); // true, compile optimization

//		String heaven4 = "discriminator" + "paradise";
//		String heaven5 = "discriminator" + "paradise";
//		System.out.println(heaven4 == heaven5); // true

		// String heaven1 = "paradise";
		// String heaven2 = "paradise";
		// String heaven3 = new String("paradise");
		// System.out.println(heaven1 == heaven3);
		StringParadise test1 = new StringParadise("a", "", "paradise");
		StringParadise test2 = new StringParadise("a", "", "heaven");
		System.out.println(test1.getKey() == test2.getKey());

	}

}
