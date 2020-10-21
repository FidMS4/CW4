package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import View.GameScreen.GameState;

public class PongCanvas extends JPanel implements ActionListener {

	private GameScreen panel;
	private Color rectColor = Color.gray;
	public static Color ballColor;
	public static Color backgroundColor;
	private int leftHits, rightHits;

	Timer t = new Timer(5, this);
	int x = 0, y = 0, velX = 4, velY = 3;

	public PongCanvas(GameScreen panel) {
		this.panel = panel;
		setPreferredSize(new Dimension(500, 500));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setBackground(backgroundColor);
		g2d.clearRect(0, 0, 500, 500);

		GameScreen.GameState state = panel.getGameState();

		if (state == GameScreen.GameState.PLAYING) { 
			t.start();
		} else if (state == GameScreen.GameState.ROUNDOVER) {
			t.stop();
		} else if (state == GameScreen.GameState.RESET) {
		
		}
		
		g2d.setColor(ballColor);
		g2d.fillOval(x, y, 25, 25);

		//paddle 1
		g2d.setColor(rectColor);
		g2d.fillRect(panel.rect1.getX(), panel.rect1.getY(), panel.rect1.getHeight(), panel.rect1.getWidth());

		//paddle 2
		g2d.setColor(rectColor);
		g2d.fillRect(panel.rect2.getX(), panel.rect2.getY(), panel.rect2.getHeight(), panel.rect2.getWidth());

		g2d.setColor(Color.RED);
		g2d.setFont(new Font("Courier", Font.BOLD, 20));
		g2d.drawString("Score: " + leftHits, 45, 75);

		g2d.setColor(Color.BLUE);
		g2d.setFont(new Font("Courier", Font.BOLD, 20));
		g2d.drawString("Score: " + rightHits, 375, 75);

		if (x < 0) {
			panel.setGameState(GameState.ROUNDOVER);
			++leftHits;
		} else if (x > 475) {
			panel.setGameState(GameState.ROUNDOVER);
			++rightHits;
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (x < 0 || x > 475) {
			velX = -velX;
		} else if (y < 0 || y > 480) {
			velY = -velY;
		} 
		
		x += velX;
		y += velY;

		panel.rect2.setY(y + 5);
		repaint();
	}

}