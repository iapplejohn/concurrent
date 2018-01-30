/**
 * 
 */
package com.jemmy.basis;

/**
 * @author Administrator
 * @date 2012-4-15
 */
public class NewPerson {
	private String name;
	private int age;
	public NewPerson() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public NewPerson(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
