/**
 * 
 */
package com.jemmy.basis;

/**
 * @author Administrator
 * @date 2012-4-15
 */
public class Name {
	private String firstName;
	private String lastName;
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
