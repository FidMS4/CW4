package Controller;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import View.GameScreen;
import View.MenuScreen;
import View.PongCanvas;
import View.GameScreen.GameState;

public class PongEventListener implements ActionListener, KeyListener {
	
	private GameScreen panel;
	public static final int MOVE_PADDLE = 25;

	public PongEventListener(GameScreen panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		if (source == panel.getExitButton()) {
			JFrame window = panel.getWindow();
			window.getContentPane().removeAll();
			var menu = new MenuScreen(window);
			menu.start();
			window.pack();
			window.revalidate();

		} else if (source == panel.getRedButton()) {
			PongCanvas.ballColor = Color.red;
			panel.getCanvas().requestFocusInWindow();
		} else if (source == panel.getBlackButton()) {
			PongCanvas.ballColor = Color.black;
			panel.getCanvas().requestFocusInWindow();
		} else if (source == panel.getOrangeButton()) {
			PongCanvas.ballColor = Color.orange;
			panel.getCanvas().requestFocusInWindow();
		} else if (source == panel.getWhiteButton()) {
			PongCanvas.backgroundColor = Color.white;
			panel.getCanvas().requestFocusInWindow();
		} else if (source == panel.getBlackButton2()) {
			PongCanvas.backgroundColor = Color.black;
			panel.getCanvas().requestFocusInWindow();
		} else if (source == panel.getResetButton()) {
			panel.setGameState(GameState.RESET);
			panel.getPlayButton().setEnabled(true);
			panel.getCanvas().requestFocusInWindow();
		} else if (source == panel.getPlayButton()) {
			panel.getPlayButton().setEnabled(false);
			panel.setGameState(GameState.PLAYING);
			panel.getCanvas().requestFocusInWindow();
		}
		panel.getCanvas().repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		var key = e.getKeyCode();
		int a = panel.rect1.getY();

		switch (key) {
			case KeyEvent.VK_UP:
				panel.rect1.setY(a - MOVE_PADDLE);
				if (panel.rect1.getY() < 0) {
					panel.rect1.setY(0);
				}
				break;

			case KeyEvent.VK_DOWN:
				panel.rect1.setY(a + MOVE_PADDLE);
				if (panel.rect1.getY() > 450) {
					panel.rect1.setY(450);
				}
				break;
		}
		panel.getCanvas().repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

}
