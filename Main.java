import javax.swing.*;

import View.MenuScreen;

public class Main {
	public static void main(String args[]) {
		JFrame window = new JFrame();
		window.setLocation(500, 150);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		var menu = new MenuScreen(window);
		menu.start();

		window.pack();
		window.setVisible(true);
	}
}
