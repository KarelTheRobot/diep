package world;

import java.awt.Graphics;

public abstract class Entity {
	private int myX, myY, myWidth, myHeight, dx, dy;
	//Accessor and modifier methods
	public int getX() {
		return myX;
	}
	public void setX(int myX) {
		this.myX = myX;
	}
	public int getY() {
		return myY;
	}
	public void setY(int myY) {
		this.myY = myY;
	}
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public int getDy() {
		return dy;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
	public int getWidth() {
		return myWidth;
	}
	public void setWidth(int myWidth) {
		this.myWidth = myWidth;
	}
	public int getHeight() {
		return myHeight;
	}
	public void setHeight(int myHeight) {
		this.myHeight = myHeight;
	}
	
	public abstract void draw(Graphics myBuffer);
	
}
