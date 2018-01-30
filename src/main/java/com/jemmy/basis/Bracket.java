package com.jemmy.basis;

public class Bracket extends Facilitate implements Relinquish {

	@Override
	public void capable() {
		System.out.println("Calling Bracket.capable()");
	}
	
	public void braces() {
		super.capable();
	}
	
	public static void main(String[] args) {
		Bracket bracket = new Bracket();
		bracket.capable();
		bracket.braces();
	}
	
}
