package com.shadystorm.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.shadystorm.handler.Handler;
import com.shadystorm.handler.Type;
import com.shadystorm.libary.Draw;

public class Particle extends GameObject{
	
	//1st constructor (overloaded)
	public Particle(GameObject object, float tickRate) {
		super(object.rec, Type.Particle, 0.0, 0.0);
		this.rec = new Rectangle(object.rec);
		color = object.getColor();
		alpha = object.alpha - object.alpha / 5;
		alphaTemp = alpha;
		alphaTick = tickRate;
	}
	
	//2nd constructor (overloaded)
	public Particle(GameObject object, float tickRate, double velX, double velY) {
		super(object.rec, Type.Particle, velX, velY);
		this.rec = new Rectangle(object.rec);
		color = object.getColor();
		alpha = object.alpha - object.alpha / 5;
		alphaTemp = alpha;
		alphaTick = tickRate;
	}
	
	//The tick() method is called by the handler each gameTick
	public void tick() {
		//Reduce the alpha value by alphaTick to make the Particle fade away
		alphaTemp -= alphaTick;
		alpha = (int) alphaTemp;
		//Remove the Particle if its alpha value is beneath zero (as it is invisible then)
		if(alpha <= 0)
			Handler.removeObject(this);
		//Apply the specified velocity on the x and y axis
		dX += velX;
		dY += velY;
		rec.x = (int)dX;
		rec.y = (int)dY;
		
	}
	
	//The render() method is called by the handler each frame
	public void render(Graphics g) {
		//Draws the Particle to the screen (using the com.shadystorm.libary.Draw libary)
		Draw.rectangle(g, color, rec, alpha);
	}
	
}
