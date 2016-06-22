package tanks;

import java.awt.Color;
import java.awt.Graphics;
import world.*;

public abstract class Tank extends Entity {
	private int myLevel;
	public Tank(double x, double y, double width, double height, double health, double direction, double speed, Color color) {
		super(x, y, width, height, health, direction, speed, color);
		setColor(DiepConstants.BULLETCOLOR);
	}
	public Tank(double x, double y, double direction) {
		super(x, y, DiepConstants.TANKSIZE, DiepConstants.TANKSIZE, DiepConstants.HEALTH, direction, 0, DiepConstants.TANKCOLOR);
	}
	public Tank(double x, double y) {
		super(x, y, DiepConstants.TANKSIZE, DiepConstants.TANKSIZE, DiepConstants.HEALTH, 90.0, 0, DiepConstants.TANKCOLOR);
	}
	public int getLevel() {
		return myLevel;
	}
	public void levelUp() {
		myLevel++;
	}
	public void draw(Graphics myBuffer) {
		myBuffer.setColor(getColor());
		super.draw(myBuffer);
		myBuffer.setColor(DiepConstants.GUNCOLOR);
		drawGuns(myBuffer);
	}
	public abstract void drawGuns(Graphics myBuffer);
}
