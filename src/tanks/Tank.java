package tanks;

import java.awt.Graphics;
import world.*;

public abstract class Tank extends Entity {
	private int myLevel;
	public Tank(double x, double y, double width, double height, double health, double direction, double speed) {
		super(x, y, width, height, health, direction, speed);
		setColor(DiepConstants.BULLETCOLOR);
	}
	public Tank(double x, double y) {
		super(x, y, DiepConstants.TANKSIZE, DiepConstants.TANKSIZE, DiepConstants.HEALTH, 90.0, 0);
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
		drawGuns();
	}
	public abstract void drawGuns();
}
