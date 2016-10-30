package com.shadystorm.libary;

import java.awt.Rectangle;

//Makes the libary final, because there is no need to change it
public final class libMath {
	
	//Makes the constructor private, so this class can't be instantiated
	private libMath(){}
	
	//The clamp() method returns the value if it is inside the min/max, if not, it returns the min (val<min) and the max (val>max)
	public static double clamp(double val, double min, double max){
		return (val<=min)?min:(val>=max)?max:val;
	}
	
	//The overlaping() method returns a boolean, if the given Rectangles overlap returns true, otherwise false
	public static boolean overlaping(Rectangle rec1, Rectangle rec2){
		if(rec1.x + rec1.width > rec2.x && rec1.x < rec2.x + rec2.width
				&& rec1.y + rec1.height > rec2.y && rec1.y < rec2.y + rec2.height)
			return true;
		return false;
	}
	
}
