package tanks;

import java.awt.*;
import world.DiepConstants;

public class DefaultTank extends Tank {
	public DefaultTank(double x, double y, double width, double height, double health, double direction, double speed, Color color) {
		super(x, y, width, height, health, direction, speed, color);
	}
	
	public DefaultTank(double x, double y, double direction) {
		super(x, y, direction);
	}
	
	public DefaultTank(double x, double y) {
		super(x, y);
	}
	public void drawGuns(Graphics myBuffer) {
		int[] x = new int[4];
		x[0] = (int)(getX()+DiepConstants.GUNWIDTH*Math.sin(Math.toRadians(getDirection()+90)));
		x[1] = (int)(getX()-DiepConstants.GUNWIDTH*Math.sin(Math.toRadians(getDirection()+90)));
		x[2] = x[1] + (int)(DiepConstants.GUNLENGTH*Math.sin(Math.toRadians(getDirection()+90)));
		x[3] = x[0] + (int)(DiepConstants.GUNLENGTH*Math.sin(Math.toRadians(getDirection()+90)));
		int[] y = new int[4];
		y[0] = (int)(getY()+DiepConstants.GUNWIDTH*Math.cos(Math.toRadians(getDirection()+90)));
		y[1] = (int)(getY()-DiepConstants.GUNWIDTH*Math.cos(Math.toRadians(getDirection()+90)));
		y[2] = y[1] + (int)(DiepConstants.GUNLENGTH*Math.cos(Math.toRadians(getDirection()+90)));
		y[3] = y[0] + (int)(DiepConstants.GUNLENGTH*Math.cos(Math.toRadians(getDirection()+90)));
		myBuffer.setColor(Color.GREEN);
		myBuffer.fillPolygon(x, y, 4);
		for (int a = 0; a < 4; a++)
		{
			System.out.println("("+x[a]+", "+y[a]+")");
			myBuffer.setColor(Color.BLACK);
			myBuffer.fillRect(x[a], y[a], 1, 1);
		}
	}

}
