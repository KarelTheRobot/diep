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
				
				DiepPanel.moveAllEntities();
				DiepPanel.drawAllEntities();
				int x;
				if (myTank.getX() < DiepConstants.FRAMEWIDTH / 2)
					x = DiepConstants.FRAMEWIDTH / 2;
				else if (myTank.getX() > DiepConstants.MAPWIDTH - DiepConstants.FRAMEWIDTH / 2)
					x = DiepConstants.MAPWIDTH - DiepConstants.FRAMEWIDTH / 2;
				else
					x = (int) myTank.getX();
				int y;
				if (myTank.getY() < DiepConstants.FRAMEHEIGHT / 2)
					y = DiepConstants.FRAMEHEIGHT / 2;
				else if (myTank.getY() > DiepConstants.MAPHEIGHT - DiepConstants.FRAMEHEIGHT / 2)
					y = DiepConstants.MAPHEIGHT - DiepConstants.FRAMEHEIGHT / 2;
				else
					y = (int) myTank.getY();
				myImage = DiepPanel.getImageCenteredOnPoint(x, y, DiepConstants.FRAMEWIDTH, DiepConstants.FRAMEHEIGHT);
				repaint();
				
			}

			
		});
		t.start();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(myImage, 0, 0, null);
	}

	private void updateDirection() {
		//TODO Can't update relative mouse position properly
	}
	private void checkKeys() {
		for (int x = 0; x < keyList.size(); x++)
			switch (keyList.get(x)) {
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
