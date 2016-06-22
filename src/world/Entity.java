package world;

import java.awt.*;

import static java.lang.Math.*;
public abstract class Entity {
	private double myX, myY, myWidth, myHeight;
	private double myHealth, myDirection, mySpeed;
	private Color myColor;
	private Polygon myPolygon;
	//Accessor and modifier methods
	public Entity(double x, double y, double width, double height, double health, double direction, double speed, Color color) {
		myX = x;
		myY = y;
		myWidth = width;
		myHeight = height;
		myHealth = health;
		myDirection = direction;
		mySpeed = speed;
		myColor = color;
		setPolygon(null);
	}
	public Color getColor() {
		return myColor;
	}
	public void setColor(Color color) {
		myColor = color;
	}
	public double getHealth() {
		return myHealth;
	}
	public void setHealth(double myHealth) {
		this.myHealth = myHealth;
	}
	public double getX() {
		return myX;
	}
	public void setX(double myX) {
		this.myX = myX;
	}
	public double getY() {
		return myY;
	}
	public void setY(double myY) {
		this.myY = myY;
	}
	public double getDirection() {
		return myDirection;
	}
	public void setDirection(double direction) {
		this.myDirection = direction;
	}
	public double getSpeed() {
		return mySpeed;
	}
	public void setSpeed(double speed) {
		this.mySpeed = speed;
	}
	public double getWidth() {
		return myWidth;
	}
	public void setWidth(double width) {
		this.myWidth = width;
	}
	public double getHeight() {
		return myHeight;
	}
	public void setHeight(double height) {
		this.myHeight = height;
	}
	public Polygon getPolygon() {
		return myPolygon;
	}
	public void setPolygon(Polygon myPolygon) {
		this.myPolygon = myPolygon;
	}
	public void draw(Graphics2D myBuffer) {
		if (myPolygon == null) {
			myBuffer.setColor(myColor);
			myBuffer.setStroke(DiepConstants.THIN);
			myBuffer.fillOval((int)(getX()-getWidth()/2), (int)(getY()-getHeight()/2), (int)(getWidth()), (int)(getHeight()));
			myBuffer.setColor(DiepConstants.OUTLINECOLOR);
			myBuffer.setStroke(DiepConstants.THICK);
			myBuffer.drawOval((int)(getX()-getWidth()/2), (int)(getY()-getHeight()/2), (int)(getWidth()), (int)(getHeight()));
		}
	}
	/**
	 * Calculates the change in x and y based on direction and speed
	 * @return an 2-value int[] contaning the horizontal and vertical movement.
	 */
	public double[] calcDxDy() {
		double[] array = new double[2]; //a terrible name for an array
		array[0] = mySpeed * sin(toRadians(myDirection));
		array[1] = mySpeed * cos(toRadians(myDirection));
		return array;
	}
}
