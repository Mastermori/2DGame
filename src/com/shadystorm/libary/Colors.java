package com.shadystorm.libary;

import java.awt.Color;

//Makes the libary final, because there is no need to change it
public final class Colors {
	
	//Makes the constructor private, so this class can't be instantiated
	private Colors(){}
	
	//The getAlphaColor() method returns a color, consisting of the given color with the alpha value added to it
	public static Color getAlphaColor(Color color, float alpha){
		Color tempColor = new Color(0f, 0f, 0f, alpha);		//Directly using alpha for the new color doesn't work
		return new Color(color.getRed(), color.getGreen(), color.getBlue(), tempColor.getAlpha());
	}
	
}
