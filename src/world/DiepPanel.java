package world;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import tanks.*;

public class DiepPanel extends JPanel {
	private BufferedImage myImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
	private Graphics g = myImage.getGraphics();
	private Graphics2D myBuffer = (Graphics2D)g;
	public DiepPanel() {
		Entity e = new DefaultTank(300, 300, 90);
		e.draw(myBuffer);
		repaint();
	}
	public void paintComponent(Graphics g) {
		g.drawImage(myImage, 0, 0, null);
	}
}
