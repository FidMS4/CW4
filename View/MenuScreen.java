package View;

import java.awt.*;
import javax.swing.*;

public class MenuScreen {

	private JFrame window;

	public MenuScreen(JFrame window) {
		this.window = window;
		window.setTitle("Play Pong!");
	}

	public void start() {
		Container cp = window.getContentPane();
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 225));
		panel.setBackground(Color.black);
	
		JButton pongButton = new JButton("Pong");
		pongButton.setPreferredSize(new Dimension(400, 190));
		JTextArea info = new JTextArea("by Fidel");
		panel.add(pongButton);
		panel.add(info);
		cp.add(BorderLayout.CENTER, panel);

		pongButton.addActionListener( e -> {
			window.getContentPane().removeAll();
			var gameplay = new GameScreen(window);
			gameplay.start();
			window.pack();
			window.revalidate();
		});
	}
}