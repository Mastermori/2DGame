package com.shadystorm.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.shadystorm.handler.Type;
import com.shadystorm.libary.Draw;

public class Player extends GameObject{
	
	//Creates the key-variables for the jump feature
	private boolean jumped;
	private int jumpTimer;
	
	//1st constructor (overloaded)
	public Player(Rectangle rec) {
		super(rec, Type.Player);
		color = Color.BLUE;
		rec.width = 32;
		rec.height = 32;
	}
	
	//2nd constructor (overloaded)
	public Player(Rectangle rec, double velX, double velY) {
		super(rec, Type.Player, velX, velY);
		color = Color.BLUE;
		rec.width = 32;
		rec.height = 32;
	}
	
	//The jump() method makes the Player jump once
	public void jump(){
		if(!jumped){
			velY = 5;
			jumped = true;
			jumpTimer = 10;
		}
	}
	
	//The up() method makes the Player go up and is called by the KeyInput class
	public void up(boolean b){
		if(b){
			velY = 3;
		}else{
			velY = 0;
		}
	}
	
	//The down() method makes the Player go down and is called by the KeyInput class
	public void down(boolean b){
		if(b){
			velY = -3;
		}else{
			velY = 0;
		}
	}
	
	//The left() method makes the Player go left and is called by the KeyInput class
	public void left(boolean b){
		if(b){
			velX = -3;
		}else{
			velX = 0;
		}
	}
	
	//The right() method makes the Player go right and is called by the KeyInput class
	public void right(boolean b){
		if(b){
			velX = 3;
		}else{
			velX = 0;
		}
	}
	
	//The tick() method is called by the handler each gameTick
	public void tick() {
		//Apply the specified velocity on the x and y axis
		dX += velX;
		dY -= velY;
		rec.x = (int)dX;
		rec.y = (int)dY;
		//Let's the jump cooldown, so it can be used again
		if(jumped){
			jumpTimer -= 1;
			if(jumpTimer <= 0){
				jumped = false;
				velY = 0;
			}
		}
		//Makes the Player stay in the Window either by bouncing him off or just blocking him
		if(bouncing){
			super.bounce();
		}else{
			super.keepInBounds();
		}
		
	}
	
	//The render() method is called by the handler each frame
	public void render(Graphics g) {
		//Draws the Particle to the screen (using the com.shadystorm.libary.Draw libary)
		Draw.rectangle(g, color, rec);
	}
	
}
