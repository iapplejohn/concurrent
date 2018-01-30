/**
 * 
 */
package com.jemmy.basis;

import java.util.Date;

/**
 * @author Administrator
 * @date 2012-4-15
 */
public class Male extends NewPerson implements Cloneable {

	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//		return super.clone();
//	}

}
