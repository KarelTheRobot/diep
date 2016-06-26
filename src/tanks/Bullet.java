package tanks;

import world.DiepConstants;
import world.Entity;

public class Bullet extends Entity {
	private int damageMod = 1;
	private int healthMod = 1;
	private int speedMod = 1;
	private Tank myTank;
	public Bullet(double x, double y, double size, double direction, Tank tank) {
		super(x, y, size, size, tank.getBaseBulletHealth(), tank.getBaseBulletDamage(), direction, 0, 0, DiepConstants.BULLETCOLOR);
		myTank = tank;
	}
	public void levelUpDamage() {
		damageMod += 0.2;
	}
	public void levelUpHealth() {
		healthMod += 0.3;
	}
	public void levelUpSpeed() {
		speedMod += 0.3;
	}
	public void move() {
		setX(getX()+(-1)*(getSpeed() * Math.sin(Math.toRadians(getDirection()))));
		setY(getY()+(-1)*(getSpeed() * Math.cos(Math.toRadians(getDirection()))));
		
	}
	public double getHealth() {
		return myTank.getBaseBulletHealth()*healthMod;
	}
	public double getDamage() {
		return myTank.getBaseBulletDamage()*damageMod;
	}
	public double getSpeed() {
		return myTank.getBaseBulletSpeed()*speedMod;
	}
}
