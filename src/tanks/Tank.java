package tanks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
	public void draw(Graphics2D myBuffer) {
		myBuffer.setColor(DiepConstants.GUNCOLOR);
		drawGuns(myBuffer);
		myBuffer.setColor(getColor());
		super.draw(myBuffer);
	}
	public abstract void drawGuns(Graphics2D myBuffer);
	public void fillGuns(int[] xPoints, int[] yPoints, Graphics2D myBuffer){
		myBuffer.setStroke(DiepConstants.THIN);
		myBuffer.setColor(DiepConstants.GUNCOLOR);
		myBuffer.fillPolygon(xPoints, yPoints, xPoints.length);
	}
	public void outlineGuns(int[] xPoints, int[] yPoints, Graphics2D myBuffer){
		myBuffer.setStroke(DiepConstants.THICK);
		myBuffer.setColor(DiepConstants.OUTLINECOLOR);
		myBuffer.drawPolygon(xPoints, yPoints, xPoints.length);
	}
}
