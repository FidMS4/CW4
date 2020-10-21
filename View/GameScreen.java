package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import Controller.PongEventListener;
import Model.Rectangle;

public class GameScreen {

	private JFrame window;
	private PongCanvas canvas;
	public Rectangle rect1 = new Rectangle(15, 225, 20, 60);
	Rectangle rect2 = new Rectangle(465, 225, 20, 60);
	private JButton playButton = new JButton("Play");
	private JButton resetButton = new JButton("Reset");
	private JRadioButton redButton = new JRadioButton("Red");
	private JRadioButton blackButton = new JRadioButton("Black");
	private JRadioButton orangeButton = new JRadioButton("Orange");
	private JRadioButton whiteButton = new JRadioButton("White");
	private JRadioButton blackButton2 = new JRadioButton("Black");
	private JButton exitButton = new JButton("Exit");

	public enum GameState { 
		PLAYING, RESET, ROUNDOVER
	}

	private GameState gState;

	public GameScreen(JFrame window) {
		this.window = window;
		window.setTitle("Playing Pong!");
	}

	public void start() {
		Container cp = window.getContentPane();

		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(3, 1));
		cp.add(BorderLayout.SOUTH, southPanel);

		canvas = new PongCanvas(this);
		cp.add(BorderLayout.CENTER, canvas);

		JPanel radioPanel = new JPanel();
		radioPanel.add(redButton);
		radioPanel.add(blackButton);
		radioPanel.add(orangeButton);
		southPanel.add(radioPanel);

		ButtonGroup colorGroup = new ButtonGroup();
		colorGroup.add(redButton);
		colorGroup.add(blackButton);
		colorGroup.add(orangeButton);

		TitledBorder title = BorderFactory.createTitledBorder("Choose ball color");
		radioPanel.setBorder(title);

		JPanel radioPanel2 = new JPanel();
		radioPanel2.add(whiteButton);
		radioPanel2.add(blackButton2);
		southPanel.add(radioPanel2);

		ButtonGroup colors2 = new ButtonGroup();
		colors2.add(whiteButton);
		colors2.add(blackButton2);

		TitledBorder title2 = BorderFactory.createTitledBorder("Choose background color");
		radioPanel2.setBorder(title2);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(playButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(exitButton);
		southPanel.add(buttonPanel);

		PongEventListener listener = new PongEventListener(this);
		exitButton.addActionListener(listener);
		resetButton.addActionListener(listener);
		playButton.addActionListener(listener);
		redButton.addActionListener(listener);
		blackButton.addActionListener(listener);
		orangeButton.addActionListener(listener);
		whiteButton.addActionListener(listener);
		blackButton2.addActionListener(listener);
		canvas.addKeyListener(listener);

	}

	public JButton getExitButton() {
		return exitButton;
	}

	public JButton getResetButton() {
		return resetButton;
	}

	public JButton getPlayButton() {
		return playButton;
	}

	public JRadioButton getRedButton() {
		return redButton;
	}

	public JRadioButton getBlackButton() {
		return blackButton;
	}

	public JRadioButton getOrangeButton() {
		return orangeButton;
	}

	public JRadioButton getWhiteButton() {
		return whiteButton;
	}

	public JRadioButton getBlackButton2() {
		return blackButton2;
	}

	public JFrame getWindow() {
		return window;
	}

	public PongCanvas getCanvas() {
		return canvas;
	}

	public GameState getGameState() {
		return gState;
	}

	public void setGameState(GameState gState) {
		this.gState = gState;
	}

}