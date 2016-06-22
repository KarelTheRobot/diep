package tanks;

import java.awt.*;
import world.DiepConstants;
import static java.lang.Math.*;
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
	public void drawGuns(Graphics2D myBuffer) {
		double x = getX();
		double y = getY();
		double l = DiepConstants.GUNLENGTH;
		double w = DiepConstants.GUNWIDTH;
		double a = toRadians(getDirection());
		double angle1 = atan(DiepConstants.GUNWIDTH/(2*DiepConstants.GUNLENGTH));
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
		/*myBuffer.fillPolygon(xPoints, yPoints, 4);
		myBuffer.setColor(DiepConstants.OUTLINECOLOR);
		myBuffer.drawPolygon(xPoints, yPoints, 4);*/
	    fillGuns(xPoints, yPoints, myBuffer);
	    outlineGuns(xPoints, yPoints, myBuffer);
	}
}
