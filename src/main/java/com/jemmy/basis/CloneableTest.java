/**
 * 
 */
package com.jemmy.basis;

import java.util.Date;

/**
 * @author Administrator
 * @date 2012-4-15
 */
public class CloneableTest {

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		// Invoking Object's clone method on an instance
		// that does not implement the Cloneable interface
		// results in the exception CloneNotSupportedException
		// being thrown.
//		CloneableTest test = new CloneableTest();
//		try {
//			Object obj = test.clone();
//			System.out.println(obj);
//		} catch (CloneNotSupportedException e) {
//			e.printStackTrace();
//		}
		
		// Note that all arrays are considered to implement
		// the interface Cloneable
		// primitive fields
//		int[] iMarks = new int[] { 4, 7, 1 , 8 };
//		int[] copyofiMarks = iMarks.clone();
		
//		Person[] persons = new Person[3];
//		persons[0] = new Person("John", 28);
//		persons[1] = new Person("Jim", 25);
//		persons[2] = new Person("Eric", 27);
//		Person[] copyOfPersons = persons.clone();
//		
//		persons[0].setAge(27);
//		persons[0].setName("Johnny");
//		for (Person person : copyOfPersons)
//			System.out.println(person.getName() + " " + person.getAge());
		
		// The class Object does not itself implement the interface
		// Cloneable, so calling the clone method on an object whose class
		// is Object will result in throwing an exception at run time.
//		Object obj = new Object();
		
//		Person person = new Person(new Name("Jack", "Lu"), 25);		
		NewPerson newPerson = new NewPerson("Jim", 25);
		Male male = new Male();
		male.setBirthday(new Date());
		ChineseMale chineseMale = new ChineseMale();
//		newPerson.clone();
		System.out.println(male.clone());
		System.out.println(chineseMale.clone());
		
//		Name name = new Name("John", "Chen");
//		Person person = new Person(name, 28);
//		Person copyOfPerson = (Person)person.clone();
//		name.setFirstName("Johnny");
//		name.setLastName("Qin");
//		person.setAge(29);
//		System.out.println(copyOfPerson.getName().getFirstName() + " " +
//				copyOfPerson.getName().getLastName() + 
//				" " + copyOfPerson.getAge());
	}
}
