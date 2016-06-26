package tanks;
import static world.DiepConstants.DECELERATION;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;

import world.*;

public abstract class Tank extends Entity {
	private int myLevel;
	private MainPanel mP;
	protected ArrayList<Bullet> bullets = new ArrayList<Bullet>();

	public Tank(double x, double y, double width, double height, double health, double damage, double direction, double DX, double DY, Color color) {
		super(x, y, width, height, health, damage, direction, DX, DY, color);
		//setColor(DiepConstants.BULLETCOLOR);
		initMainPanel();
	}
	/*public Tank(double x, double y, double direction, double DX, double DY) {
		super(x, y, TankConstants.TANKSIZE, TankConstants.TANKSIZE, TankConstants.DEFAULTHEALTH, TankConstants.DEFAULTDAMAGE, direction, DX, DY, DiepConstants.TANKCOLOR);
		initMainPanel();
	}
	public Tank(double x, double y, double direction) {
		super(x, y, TankConstants.TANKSIZE, TankConstants.TANKSIZE, TankConstants.DEFAULTHEALTH, TankConstants.DEFAULTDAMAGE, direction, 0, 0, DiepConstants.TANKCOLOR);
		initMainPanel();
	}
	public Tank(double x, double y) {
		super(x, y, TankConstants.TANKSIZE, TankConstants.TANKSIZE, TankConstants.DEFAULTHEALTH, TankConstants.DEFAULTDAMAGE, 90.0, 0, 0, DiepConstants.TANKCOLOR);
		initMainPanel();
	}*/
	private void initMainPanel() {
		mP = new MainPanel(this);
		JFrame frame = new JFrame();
		frame.setContentPane(mP);
		frame.setSize(DiepConstants.FRAMEWIDTH, DiepConstants.FRAMEHEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public abstract void fireBullet();
	public abstract double getBaseBulletDamage();
	public abstract double getBaseBulletSpeed();
	public abstract double getBaseBulletHealth();
	public static double tankSize() {
		return 50.0;
	}
	public static double tankHealth() { 
		return 100.0;
	}
	public static double tankDamage() {
		return 5.0;
	}
	public static double gunWidth() {
		return 30.0;
	}
	public static double gunLength() {
		return 70.0;
	}
	public void checkBullets() {
		for (int x = 0; x < bullets.size(); x++) {
			Bullet b = bullets.get(x);
			if (b.getX() < 0 || b.getX() > DiepConstants.MAPWIDTH || b.getY() < 0 || b.getY() > DiepConstants.MAPHEIGHT)
				bullets.remove(x);
		}
	}
	public int getLevel() {
		return myLevel;
	}
	public void levelUp() {
		myLevel++;
	}
	public void draw(Graphics2D myBuffer) {
		for (Bullet b : bullets)
			b.draw(myBuffer);
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
		myBuffer.setStroke(DiepConstants.MEDIUM);
		myBuffer.setColor(DiepConstants.OUTLINECOLOR);
		myBuffer.drawPolygon(xPoints, yPoints, xPoints.length);
	}
	public void move() {
		setX(getX()+getdx());
		setY(getY()+getdy());
		setdx(getdx()*DECELERATION);
		setdy(getdy()*DECELERATION);
		for (Bullet b : bullets)
			b.move();
	}
}