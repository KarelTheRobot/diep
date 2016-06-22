package world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import tanks.*;

public class DiepPanel extends JPanel {
	private BufferedImage myImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
	private Graphics myBuffer = myImage.getGraphics();
	public DiepPanel() {
		myBuffer.setColor(Color.RED);
		myBuffer.fillRect(0, 0, 800, 600);
		Entity e = new DefaultTank(300, 300, 0);
		e.draw(myBuffer);
		repaint();
	}
	public void paintComponent(Graphics g) {
		g.drawImage(myImage, 0, 0, null);
	}
}
