package world;
import java.util.ArrayList;
import java.awt.*;
import java.awt.image.BufferedImage;
import tanks.*;
import static world.DiepConstants.*;

public class DiepPanel {
	private static BufferedImage myImage = new BufferedImage(MAPWIDTH, MAPHEIGHT, BufferedImage.TYPE_INT_ARGB);
	private static Graphics g = myImage.getGraphics();
	private static Graphics2D myBuffer = (Graphics2D)g;
	private static ArrayList<Entity> entities;
	public static void main(String[] args) {
		entities = new ArrayList<Entity>();
		entities.add(new DefaultTank(3000, 300, 135, 4, 0));
	}
	public static void moveAllEntities() {
		myBuffer.setColor(BACKGROUND.darker());
		//fill 4 borders- faster than one huge rectangle
		myBuffer.fillRect(0, 0, MAPWIDTH, FRAMEHEIGHT/2);
		myBuffer.fillRect(0, 0, FRAMEWIDTH/2, MAPHEIGHT);
		myBuffer.fillRect(0, MAPHEIGHT-FRAMEHEIGHT/2, MAPWIDTH, FRAMEHEIGHT/2);
		myBuffer.fillRect(MAPWIDTH-FRAMEWIDTH/2, 0, FRAMEWIDTH/2, MAPHEIGHT);
		
		myBuffer.setColor(BACKGROUND);
		myBuffer.fillRect(FRAMEWIDTH/2, FRAMEHEIGHT/2,
				MAPWIDTH-FRAMEWIDTH, MAPHEIGHT-FRAMEHEIGHT);
		myBuffer.setColor(BACKGROUNDLINECOLOR);
		myBuffer.setStroke(THIN);
		for (int x = 0; x < MAPWIDTH; x+=BACKGROUNDLINESPACING)
			myBuffer.drawLine(x, 0, x, MAPHEIGHT);
		for (int y = 0; y < MAPHEIGHT; y+= BACKGROUNDLINESPACING)
			myBuffer.drawLine(0, y, MAPWIDTH, y);
		for (Entity e : entities) {
			e.move();
			if (e instanceof Tank) {
				((Tank)e).checkBullets();
			}
		}
	}
	public static void drawAllEntities() {
		for (Entity e : entities) {
			e.draw(myBuffer);
		}
	}
	public static BufferedImage getImageCenteredOnPoint(int x, int y, int width, int height) {
//		System.out.println(x-width/2+" " + (y-height/2)+ " " + width+ " " + height);
		return myImage.getSubimage(x-width/2, y-height/2, width, height);
	}
}