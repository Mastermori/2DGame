package com.shadystorm.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.shadystorm.handler.Handler;
import com.shadystorm.handler.Type;
import com.shadystorm.libary.libMath;
import com.shadystorm.main.Main;

public abstract class GameObject {
	
	//Create native GameObject vars
	protected int id;
	protected Rectangle rec;
	protected Type type;
	protected double velX, velY, dX, dY;
	protected boolean bouncing;
	protected Color color;
	protected float alpha, alphaTemp, alphaTick;
	
	//1st constructor (overloaded)
	public GameObject(Rectangle rec, Type type){
		//Calls the construct method with added vars, wich aren't in the constructor call
		construct(rec, type, 0.0, 0.0);
	}
	
	//2nd constructor (overloaded)
	public GameObject(Rectangle rec, Type type, double velX, double velY){
		//Calls the construct method with added vars, wich aren't in the constructor call
		construct(rec, type, velX, velY);
	}
	
	//Create the methods wich must be implemented in all child classes
	public abstract void tick();
	public abstract void render(Graphics g);
	
	//The bounce method makes the GameObject bounce of the window edges, if called in tick()
	protected void bounce(){
		if((rec.x + rec.width >= Main.WIDTH && velX > 0) || (rec.x <= 0 && velX < 0)){
			velX = velX * -1;
		}
		if((rec.y + rec.height * 1.75 >= Main.HEIGHT && velY < 0) || (rec.y <= 0 && velY > 0)){
			velY = velY * -1;
		}
	}
	
	//The keepInBounds method keeps the GameObject inside the window edges, if called in tick()
	protected void keepInBounds(){
		rec.x = (int) libMath.clamp(rec.x, 0, Main.WIDTH - rec.width);
		rec.y = (int) libMath.clamp(rec.y, 0, Main.HEIGHT - rec.height);
	}
	
	//The construct method, wich is called in the constructor, is used to initialize each instance of the class
	private void construct(Rectangle rec, Type type, double velX, double velY){
		this.rec = rec;
		this.dX = rec.x;
		this.dY = rec.y;
		this.velX = velX;
		this.velY = velY;
		this.id = Handler.getNewID();		//Gets an unused id from the handler
		this.alpha = 100f;
	}
	
	//The scale method is used to scale a GameObject by an int !! WIP !!
	public GameObject scale(int scale){
		rec.x -= scale / 2;
		rec.y -= scale / 2;
		rec.width *= scale;
		rec.height *= scale;
		return this;
	}
	
	//Getters for all important vars
	public int getX() { return rec.x; }
	public int getY() { return rec.y; }
	public Type getType() { return type; }
	public double getVelX() { return velX; }
	public double getVelY() { return velY; }
	public int getWidth(){ return rec.width; }
	public int getHeight(){ return rec.height; }
	public Color getColor(){ return color; }
	public float getAlpha(){ return alpha; }
	public int getID(){ return id; }
	public Rectangle getRec(){ return rec; }
	
	//Setters for all important vars (returns itself for method stacking (example: gameObject.setX(10).setY(20).setWidth(5).setHeight(5))
	public GameObject setX(int x) { this.rec.x = x; return this; }
	public GameObject setY(int y) { this.rec.y = y; return this; }
	public GameObject setType(Type type) { this.type = type; return this; }
	public GameObject setVelX(double velX) { this.velX = velX; return this; }
	public GameObject setVelY(double velY) { this.velY = velY; return this; }
	public GameObject setWidth(int width){ this.rec.width = width; return this; }
	public GameObject setHeight(int height){ this.rec.height = height; return this; }
	public GameObject setColor(Color color){ this.color = color; return this; }
	public GameObject setAlpha(float alpha){ this.alpha = alpha; return this; }
	public GameObject setID(int id){ this.id = id; return this; }
	public GameObject setRec(Rectangle rec){ this.rec = rec; return this; }
	
}
