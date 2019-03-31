package com.ragnarok.controller.utils;

public class Vector2 {

	public int X;
	public int Y;
	
	public Vector2() { }
	public Vector2(int X, int Y) { this.X = X; this.Y = Y; }
	
	public void normalized()
	{
		Vector2 aux = VectorUtils.normalize(new Vector2(this.getX(), this.getY()));
		this.setX(aux.getX());
		this.setY(aux.getY());
	}
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + X;
		result = prime * result + Y;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector2 other = (Vector2) obj;
		if (X != other.X)
			return false;
		if (Y != other.Y)
			return false;
		return true;
	}
	
	public int getX() {
		return X;
	}
	
	public void setX(int x) {
		X = x;
	}
	
	public int getY() {
		return Y;
	}
	
	public void setY(int y) {
		Y = y;
	}
	
}
