package com.ragnarok.model;

import java.awt.Color;
import java.awt.Graphics;

import com.ragnarok.controller.utils.Vector2;

public class Ball implements Drawable
{

	private int size;
	private Vector2 position;
	private Vector2 speed;
	private Vector2 direction;

	public Ball(Vector2 position)
	{
		this.size = 10;
		this.position = position;
		this.speed = new Vector2(2, 0);
		this.direction = new Vector2(1, 1);
	}

	public boolean isOutOfWindow(int windowWidth, int windowHeight)
	{
		if(this.getPositionX() + this.getSize() > windowWidth || this.getPositionX() < 0)
			return true;
		else if(this.getPositionY() + this.getSize() > windowHeight || this.getPositionY() < 0)
			return true;
		return false;
	}

	public void move()
	{
		this.setPositionX(this.getPositionX() + this.getSize() * this.speed.getX() * this.direction.getX());
		this.setPositionY(this.getPositionY() + this.getSize() * this.speed.getY() * this.direction.getY());
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

	public Vector2 getSpeed()
	{
		return speed;
	}

	public void setSpeed(Vector2 speed)
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
		g.fillRect(this.getPositionX(), this.getPositionY(), this.size, this.size);

	}

}
