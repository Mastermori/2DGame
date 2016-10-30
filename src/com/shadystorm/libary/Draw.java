package com.shadystorm.libary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

//Makes the libary final, because there is no need to change it
public final class Draw {
	
	//Makes the constructor private, so this class can't be instantiated
	private Draw(){}
	
	//The rectangle() method draws a rectangle with the given values to the screen (1st overload)
	public static void rectangle(Graphics g, Color color, int x, int y, int width, int height){
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	
	//The rectangle() method draws a rectangle with the given values to the screen (2nd overload)
	public static void rectangle(Graphics g, Color color, int x, int y, int width, int height, float alpha){
		g.setColor(Colors.getAlphaColor(color, alpha/100f));
		g.fillRect(x, y, width, height);
	}
	
	//The rectangle() method draws a rectangle with the given values to the screen (3rd overload)
	public static void rectangle(Graphics g, Color color, Rectangle rec, float alpha){
		g.setColor(Colors.getAlphaColor(color, alpha/100f));
		g.fillRect(rec.x, rec.y, rec.width, rec.height);
	}
	
	//The rectangle() method draws a rectangle with the given values to the screen (4th overload)
	public static void rectangle(Graphics g, Color color, Rectangle rec){
		g.setColor(color);
		g.fillRect(rec.x, rec.y, rec.width, rec.height);
	}
	
}
