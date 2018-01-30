/**
 * 
 */
package com.jemmy.enhancement;

/**
 * @author Administrator
 * @date 2012-4-7
 */
public class ReflectPoint {
	private int x;
	private int y;
	
	public ReflectPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
		return x * 17 + y;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return this == null;
		
		if (obj instanceof ReflectPoint) {
			ReflectPoint other = (ReflectPoint)obj;
			return this.x == other.x && 
					this.y == other.y;
		} else {
			return false;
		}
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
