package com.ragnarok.controller.utils;

/**
 * ============================================
 * Utils Source code for Vector 2D 
 * 
 * @author Sergio Martinez Roman
 * Date: 31/03/2019
 * ============================================
 * */
public class VectorUtils
{
	
	// Compute magnitude of vector.
	public static double getVectorMagnitude(int X, int Y)
	{
		// The correctly rounded positive square root of a double value
		double magnitude = Math.sqrt(X * X + Y * Y);
		return magnitude;
	}

	// Normalize the vector's magnitude
	public static Vector2 normalize(Vector2 vector)
	{
		double magnitude = getVectorMagnitude(vector.getX(), vector.getY());
		
		if(magnitude != 0) 
		{
			vector.setX((int) Math.round(vector.getX()/magnitude));
			vector.setY((int) Math.round(vector.getY()/magnitude));
		}
		
		return vector;
	}

}
