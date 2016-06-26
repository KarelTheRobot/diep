package world;

import java.awt.*;


public abstract class Entity {
	private double myX, myY, myWidth, myHeight;
	private double myHealth, myDirection, dx, dy, myDamage;
	private Color myColor;
	private Polygon myPolygon;

	public Entity(double x, double y, double width, double height, double health, double damage, double direction, double DX,
			double DY, Color color) {
		myX = x;
		myY = y;
		myWidth = width;
		myHeight = height;
		myHealth = health;
		setDamage(damage);
		myDirection = direction;
		dx = DX;
		dy = DY;
		myColor = color;
		setPolygon(null);
	}
	// Accessor and modifier methods
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

	public double getDamage() {
		return myDamage;
	}
	public void setDamage(double myDamage) {
		this.myDamage = myDamage;
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

	public double getdx() {
		return dx;
	}

	public void setdx(double DX) {
		this.dx = DX;
	}

	public double getdy() {
		return dy;
	}

	public void setdy(double DY) {
		this.dy = DY;
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
			myBuffer.fillOval((int) (getX() - getWidth() / 2), (int) (getY() - getHeight() / 2), (int) (getWidth()),
					(int) (getHeight()));
			myBuffer.setColor(DiepConstants.OUTLINECOLOR);
			myBuffer.setStroke(DiepConstants.MEDIUM);
			myBuffer.drawOval((int) (getX() - getWidth() / 2), (int) (getY() - getHeight() / 2), (int) (getWidth()),
					(int) (getHeight()));
		}
		else {
			myBuffer.setColor(myColor);
			myBuffer.setStroke(DiepConstants.THIN);
			myBuffer.fillPolygon(myPolygon);
			myBuffer.setColor(DiepConstants.OUTLINECOLOR);
			myBuffer.setStroke(DiepConstants.MEDIUM);
			myBuffer.drawPolygon(myPolygon);
		}
	}
	public abstract void move();
}
