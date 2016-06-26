package tanks;

import java.awt.*;

import world.DiepConstants;
import static tanks.TankConstants.*;
import static java.lang.Math.*;
public class DefaultTank extends Tank {
	public DefaultTank(double x, double y, double width, double height, double health, double damage, double direction, double DX, double DY, Color color) {
		super(x, y, width, height, health, damage, direction, DX, DY, color);
	}
	public DefaultTank(double x, double y, double direction, double DX, double DY) {
		super(x, y, DEFAULTSIZE, DEFAULTSIZE, DEFAULTHEALTH, DEFAULTDAMAGE, direction, DX, DY, DiepConstants.TANKCOLOR);
	}
	public DefaultTank(double x, double y, double direction) {
		super(x, y, DEFAULTSIZE, DEFAULTSIZE, DEFAULTHEALTH, DEFAULTDAMAGE, direction, 0, 0, DiepConstants.TANKCOLOR);
	}
	public DefaultTank(double x, double y) {
		super(x, y, DEFAULTSIZE, DEFAULTSIZE, DEFAULTHEALTH, DEFAULTDAMAGE, 0, 0, 0, DiepConstants.TANKCOLOR);
	}
	public void fireBullet() {
		bullets.add(new Bullet(getX()-DEFAULTGUNLENGTH*Math.sin(Math.toRadians(getDirection())), getY()-DEFAULTGUNLENGTH*Math.cos(Math.toRadians(getDirection())), 20, getDirection(), this));
		System.out.println(getDirection());
	}
	public void drawGuns(Graphics2D myBuffer) {
		double x = getX();
		double y = getY();
		double l = DEFAULTGUNLENGTH;
		double w = DEFAULTGUNWIDTH;
		double a = toRadians(getDirection());
		double angle1 = atan(DEFAULTGUNWIDTH/(2*DEFAULTGUNLENGTH));
	    double angle2 = PI/2 - angle1 + a;
	    double angle3 = PI/2 + angle1 + a;
	    double length = l/cos(angle1);
	    int[] xPoints = {
	    		(int)(x+w*cos(a)/2),
	    		(int)(x+cos(angle2)*length),
	    		(int)(x+cos(angle3)*length),
	    		(int)(x-w*cos(a)/2)
	    	};
	    int[] yPoints = {
	    		(int)(y-w*sin(a)/2),
	    		(int)(y-sin(angle2)*length),
	    		(int)(y-sin(angle3)*length),
	    		(int)(y+w*sin(a)/2)
	    	};
	    fillGuns(xPoints, yPoints, myBuffer);
	    outlineGuns(xPoints, yPoints, myBuffer);
	}
	public double getBaseBulletDamage() {
		return 5.0;
	}
	public double getBaseBulletSpeed() {
		return 3.0;
	}
	public double getBaseBulletHealth() {
		return 10.0;
	}
}
