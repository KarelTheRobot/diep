

import javax.swing.JFrame;

import world.DiepPanel;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Diep.io");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new DiepPanel());
		frame.setVisible(true);
	}
}