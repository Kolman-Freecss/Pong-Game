package com.ragnarok.model;

import java.awt.Color;
import java.awt.Graphics;

import com.ragnarok.controller.BaseGame;
import com.ragnarok.controller.utils.Vector2;

public class Racket implements Drawable
{

	private Vector2 position;
	private int lastPositionY;
	private Vector2 size;
	private Vector2 direction;
	private int speed;
	private Player player;

	public Racket(int numberPlayer)
	{

		this.size = new Vector2(8, 36);
		if (numberPlayer == 1)
		{
			this.position = new Vector2(this.size.X, BaseGame.GAME_WINDOW_HEIGHT / 2 - this.size.X);
		} else if (numberPlayer == 2)
		{
			int number = this.size.X * 4;
			this.position = new Vector2(BaseGame.GAME_WINDOW_WIDTH - number,
					BaseGame.GAME_WINDOW_HEIGHT / 2 - this.size.X);
		}
		this.lastPositionY = this.getPositionY();
		this.player = new Player(numberPlayer);
		/* The racket only have 2 directions UP or DOWN */
		this.speed = 20;
		this.direction = new Vector2(0, 1);

	}

	public Ball collideWithBall(Ball ball)
	{
		boolean isCollide = false;
		if (this.player.getNumberPlayer() == 1)
			if (this.getPositionX() + this.getSize().getX() > ball.getPositionX()
					&& this.getPositionY() < ball.getPositionY()
					&& this.getPositionY() + this.getSize().getY() > ball.getPositionY() + ball.getSize())
			{
				isCollide = true;
			}
		if (this.player.getNumberPlayer() == 2)
			if (this.getPositionX() < ball.getPositionX() + ball.getSize()
					&& this.getPositionY() < ball.getPositionY()
					&& this.getPositionY() + this.getSize().getY() > ball.getPositionY() + ball.getSize())
			{
				isCollide = true;
			}

		// Flip, change direction and sum punctuation to the player.
		if (isCollide)
		{
			int X = -(ball.getDirection().getX());
			int Y = (int) Math.round(Math.random()) * 2 - 1;
			ball.setDirection(new Vector2(X, Y));
			ball.getDirection().normalized();
			this.player.setPunctuation(this.player.getPunctuation() + 1);
		}

		return ball;
	}

	public void move()
	{
		this.setLastPositionY(this.getPositionY());
		this.setPositionY(this.getPositionY() + this.direction.getY() * this.speed);
	}

	public boolean isOutOfWindow(int windowHeight)
	{
		if (this.getPositionY() + this.getSize().getY() > windowHeight || this.getPositionY() < 0)
			return true;
		return false;
	}

	@Override
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(this.getPositionX(), this.getPositionY(), this.getSize().X, this.getSize().Y);
	}

	public int getLastPositionY()
	{
		return lastPositionY;
	}

	public void setLastPositionY(int lastPositionY)
	{
		this.lastPositionY = lastPositionY;
	}

	public Vector2 getPosition()
	{
		return position;
	}

	public void setPosition(Vector2 position)
	{
		this.position = position;
	}

	public Vector2 getSize()
	{
		return size;
	}

	public void setSize(Vector2 size)
	{
		this.size = size;
	}

	public Vector2 getDirection()
	{
		return direction;
	}

	public void setDirection(Vector2 direction)
	{
		this.direction = direction;
	}

	public int getSpeed()
	{
		return speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	public Player getPlayer()
	{
		return player;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}

	public void setPositionX(int position)
	{
		this.position.setX(position);
	}

	public void setPositionY(int position)
	{
		this.position.setY(position);
	}

	public int getPositionX()
	{
		return this.getPosition().getX();
	}

	public int getPositionY()
	{
		return this.getPosition().getY();
	}

}
