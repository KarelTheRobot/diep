package world;

import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import tanks.Tank;
import javax.swing.*;

public class MainPanel extends JPanel {
	private BufferedImage myImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
	private Tank myTank;
	private ArrayList<Integer> keyList = new ArrayList<Integer>();
	private int mouseX, mouseY;

	public MainPanel(Tank tank) {
		myTank = tank;
		setFocusable(true);
		requestFocus();
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				keyList.add(e.getKeyCode());
			}

			public void keyReleased(KeyEvent e) {
				if (keyList.contains(e.getKeyCode()))
					keyList.remove(keyList.indexOf(e.getKeyCode()));
			}
		});
		addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}

			public void mouseMoved(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		Timer t = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkKeys();
				updateDirection();
				DiepPanel.moveAllEntities();
				DiepPanel.drawAllEntities();

				if (myTank.getX() < DiepConstants.FRAMEWIDTH / 2) {
					myTank.setdx(myTank.getdx() * -0.9);
					myTank.setX(DiepConstants.FRAMEWIDTH / 2);
				} else if (myTank.getX() > DiepConstants.MAPWIDTH - DiepConstants.FRAMEWIDTH / 2) {
					myTank.setdx(myTank.getdx() * -0.9);
					myTank.setX(DiepConstants.MAPWIDTH - DiepConstants.FRAMEWIDTH / 2);
				}
				if (myTank.getY() < DiepConstants.FRAMEHEIGHT / 2) {
					myTank.setdy(myTank.getdy() * -0.9);
					myTank.setY(DiepConstants.FRAMEHEIGHT / 2);
				} else if (myTank.getY() > DiepConstants.MAPHEIGHT - DiepConstants.FRAMEHEIGHT / 2) {
					myTank.setdy(myTank.getdy() * -0.9);
					myTank.setY(DiepConstants.MAPHEIGHT - DiepConstants.FRAMEHEIGHT / 2);
				}
				myImage = DiepPanel.getImageCenteredOnPoint((int) myTank.getX(), (int) myTank.getY(),
						DiepConstants.FRAMEWIDTH, DiepConstants.FRAMEHEIGHT);
				repaint();
			}

		});
		t.start();
	}

	public void paintComponent(Graphics g) {
		// g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null); //RESIZES?
		g.drawImage(myImage, 0, 0, null);
	}

	private void updateDirection() {
		double d1 = (DiepConstants.FRAMEWIDTH / 2 - mouseX);
		double d2 = d1 / (DiepConstants.FRAMEHEIGHT / 2 - mouseY);
		if (!new Double(d2).isNaN()) {
			double d3 = Math.toDegrees(Math.atan(d2));
			if (mouseY > DiepConstants.FRAMEHEIGHT / 2)
				d3 += 180;
			myTank.setDirection(d3);
		}
	}

	private void checkKeys() {
		for (int i = 0; i < keyList.size(); i++) {
			switch (keyList.get(i)) {
			case KeyEvent.VK_W:
				myTank.setdy(myTank.getdy() - DiepConstants.ACCELERATION);
				break;
			case KeyEvent.VK_S:
				myTank.setdy(myTank.getdy() + DiepConstants.ACCELERATION);
				break;
			case KeyEvent.VK_A:
				myTank.setdx(myTank.getdx() - DiepConstants.ACCELERATION);
				break;
			case KeyEvent.VK_D:
				myTank.setdx(myTank.getdx() + DiepConstants.ACCELERATION);
				break;
			}
		}
	}
}
