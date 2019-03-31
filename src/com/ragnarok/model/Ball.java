package com.ragnarok.model;

import java.awt.Color;
import java.awt.Graphics;

import com.ragnarok.controller.BaseGame;
import com.ragnarok.controller.utils.Vector2;

public class Ball implements Drawable
{

	private int size;
	private Vector2 position;
	private int speed;
	private Vector2 direction;

	public Ball(Vector2 position)
	{
		this.size = 10;
		this.position = position;
		this.speed = 10;
		this.direction = new Vector2((int) Math.round(Math.random()) * 2 - 1, (int) Math.round(Math.random()) * 2 - 1);
	}

	public void collisionRoofFloor()
	{
		if((this.getPositionY() < 0 && this.getDirection().getY() < 0) || (this.getPositionY() + this.size * 4 > BaseGame.GAME_WINDOW_HEIGHT && this.getDirection().getY() > 0))
		{
			//Change the sign of the number.
			this.direction.setY(-(this.direction.getY()));
		}
	}
	
	//Check for game over
	public boolean isOutOfLimits(int windowWidth, int windowHeight)
	{
		if(this.getPositionX() + this.getSize() > windowWidth || this.getPositionX() < 0)
			return true;
		return false;
	}

	public void move()
	{
		this.setPositionX(this.getPositionX() + this.direction.getX() * this.speed);
		this.setPositionY(this.getPositionY() + this.direction.getY() * this.speed);
	}

	public void setPositionX(int position)
	{
		this.position.setX(position);
	}

	public void setPositionY(int position)
	{
		this.position.setY(position);
	}

	public int getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public Vector2 getPosition()
	{
		return position;
	}

	public void setPosition(Vector2 position)
	{
		this.position = position;
	}

	public int getSpeed()
	{
		return speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	public Vector2 getDirection()
	{
		return direction;
	}

	public void setDirection(Vector2 direction)
	{
		this.direction = direction;
	}

	public int getPositionX()
	{
		return this.getPosition().getX();
	}

	public int getPositionY()
	{
		return this.getPosition().getY();
	}

	@Override
	public void draw(Graphics g)
	{

		g.setColor(Color.RED);
		g.fillOval(this.getPositionX(), this.getPositionY(), this.size, this.size);

	}

}
