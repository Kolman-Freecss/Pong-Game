package com.ragnarok.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.ragnarok.controller.utils.Vector2;
import com.ragnarok.model.Ball;
import com.ragnarok.model.GameContainer;
import com.ragnarok.model.Racket;

public class BaseGame
{

	public static final int GAME_WINDOW_WIDTH = 800;
	public static final int GAME_WINDOW_HEIGHT = 600;
	//Refresh of the game
	private static int GAME_SPEED = 100;

	private static GameContainer container;
	private static Racket racket1;
	private static Racket racket2;
	private static Ball ball;
	private JFrame frame;

	public BaseGame()
	{
		init();
	}

	private void init()
	{
		racket1 = new Racket(1);
		racket2 = new Racket(2);
		// We pass as parameter the position of Ball, middle of the screen / 2 and the
		// size of the ball
		ball = new Ball(new Vector2(GAME_WINDOW_WIDTH / 2 - 5, GAME_WINDOW_HEIGHT / 2 - 5));
		frame = new JFrame("Pong Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBackground(Color.BLACK);

		container = new GameContainer(GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT) {

			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g)
			{
				// TODO Fix it.
				racket1.draw(g);
				racket2.draw(g);
				ball.draw(g);
			}

		};

		// Assign of Key Bindings.
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
			}

			@Override
			public void keyPressed(KeyEvent e)
			{

				int keyCode = e.getKeyCode();
				switch (keyCode)
				{
				case KeyEvent.VK_UP:
					if (!racket2.getDirection().equals(new Vector2(0, 1)))
						racket2.setDirection(new Vector2(0, -1));
						racket2.setSpeed(new Vector2(0, -1));
						racket2.move();
					break;
				case KeyEvent.VK_DOWN:
					if (!racket2.getDirection().equals(new Vector2(0, -1)))
						racket2.setDirection(new Vector2(0, 1));
						racket2.setSpeed(new Vector2(0, 1));
						racket2.move();
					break;
				// UP
				case KeyEvent.VK_W:
					if (!racket1.getDirection().equals(new Vector2(0, 1)))
						racket1.setDirection(new Vector2(0, -1));
						racket1.setSpeed(new Vector2(0, -1));
						racket1.move();
					break;
				// DOWN
				case KeyEvent.VK_S:
					if (!racket1.getDirection().equals(new Vector2(0, -1)))
						racket1.setDirection(new Vector2(0, 1));
						racket1.setSpeed(new Vector2(0, 1));
						racket1.move();
					break;
				default:
					break;
				}

			}
		});
		
		frame.add(container);
		frame.setSize(container.getWindowWidth(), container.getWindowWidth());
		frame.setVisible(true);
	}
	
	public void gameLoop() 
	{
		while (true)
		{
			if(racket1.collideWithBall(ball, 1))
			{
				ball.setDirection(new Vector2(1, 0));
				racket1.getPlayer().setPunctuation(racket1.getPlayer().getPunctuation() + 1);
				
			}
			if(racket2.collideWithBall(ball, 2))
			{
				ball.setDirection(new Vector2(-1, 0));
				racket2.getPlayer().setPunctuation(racket2.getPlayer().getPunctuation() + 1);
				
			}
			
			ball.move();
			this.frame.repaint();
			if(racket1.isOutOfWindow((int)container.getSize().getWidth()))
			{
				racket1.setPositionY(racket1.getLastPositionY());
			}
			if(racket2.isOutOfWindow((int)container.getSize().getWidth()))
			{
				racket2.setPositionY(racket2.getLastPositionY());
			}
			try {
				Thread.sleep(GAME_SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
