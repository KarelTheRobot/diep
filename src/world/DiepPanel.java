package world;
import java.util.ArrayList;
import java.awt.*;
import java.awt.image.BufferedImage;
import tanks.*;

public class DiepPanel {
	private static BufferedImage myImage = new BufferedImage(DiepConstants.MAPWIDTH, DiepConstants.MAPHEIGHT, BufferedImage.TYPE_INT_ARGB);
	private static Graphics g = myImage.getGraphics();
	private static Graphics2D myBuffer = (Graphics2D)g;
	private static ArrayList<Entity> entities;
	public static void main(String[] args) {
		entities = new ArrayList<Entity>();
		entities.add(new DefaultTank(3000, 300, 135, 4, 0));
	}
	public static void moveAllEntities() {
		myBuffer.setColor(DiepConstants.BACKGROUND);
		myBuffer.fillRect(0, 0,
				DiepConstants.MAPWIDTH, DiepConstants.MAPHEIGHT);
		myBuffer.setColor(DiepConstants.BACKGROUNDLINECOLOR);
		myBuffer.setStroke(DiepConstants.THIN);
		for (int x = 0; x < DiepConstants.MAPWIDTH; x+=DiepConstants.BACKGROUNDLINESPACING)
			myBuffer.drawLine(x, 0, x, DiepConstants.MAPHEIGHT);
		for (int y = 0; y < DiepConstants.MAPHEIGHT; y+= DiepConstants.BACKGROUNDLINESPACING)
			myBuffer.drawLine(0, y, DiepConstants.MAPWIDTH, y);
		for (Entity e : entities) {
			e.setX(e.getX()+e.getdx());
			e.setY(e.getY()+e.getdy());
			e.setdx(e.getdx()*DiepConstants.DECELERATION);
			e.setdy(e.getdy()*DiepConstants.DECELERATION);
		}
	}
	public static void drawAllEntities() {
		for (Entity e : entities) {
			e.draw(myBuffer);
		}
	}
	public static BufferedImage getImageCenteredOnPoint(int x, int y, int width, int height) {
		return myImage.getSubimage(x-width/2, y-height/2, width, height);
	}
}