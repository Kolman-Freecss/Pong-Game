package com.ragnarok.model;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class GameContainer extends JPanel{

	public GameContainer() {}
	
	public GameContainer(int windowWidth, int windowHeight) {
		
		this.setWindowWidth(windowWidth);
		this.setWindowHeigth(windowHeight);
		
	}

	public int getWindowWidth() 
	{
		return this.getWidth();
	}
	
	public int getWindowHeight()
	{
		return this.getHeight();
	}
	
	public void setWindowWidth(int width)
	{
		this.setSize(width, this.getWindowHeight());
	}
	
	public void setWindowHeigth(int heigth)
	{
		this.setSize(this.getWindowWidth(), heigth);
	}
	
	@Override
	public abstract void paintComponent(Graphics g);
	
}
