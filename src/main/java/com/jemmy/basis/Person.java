/**
 * 
 */
package com.jemmy.basis;

/**
 * @author Administrator
 * @date 2012-4-15
 */
public class Person {
	private Name name;
	private int age;
	public Person(Name name, int age) {
		this.name = name;
		this.age = age;
	}
	public Person() {
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	@Override
	protected Object clone() throws CloneNotSupportedException {
//////		Person person = new Person();
//////		person.name = name;
//////		person.age = age;
//////		return person;
		return super.clone();
	}
}
