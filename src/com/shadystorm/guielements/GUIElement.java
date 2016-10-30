package com.shadystorm.guielements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.shadystorm.handler.GUIHandler;

public abstract class GUIElement {
	
	protected boolean hidden;
	protected Rectangle rec;
	protected int id;
	protected GUIType type;
	protected float alpha;
	protected Color color;
	protected String value;
	
	public abstract void render(Graphics g);
	
	protected GUIElement(Rectangle rec, GUIType type){
		this.rec = rec;
		this.type = type;
		this.id = GUIHandler.getNewID();
		this.hidden = true;
		this.alpha = 100f;
	}
	
	public void press(){
		System.out.println("Clicked on object id: " + id + ", type: " + type + ", value: " + value);
	}
	
	public boolean isHidden(){ return hidden; }
	public Rectangle getRec(){ return rec; }
	public int getX(){ return rec.x; }
	public int getY(){ return rec.y; }
	public int getWidth(){ return rec.width; }
	public int getHeight(){ return rec.height; }
	public GUIType getType(){ return type; }
	public float getAlpha(){ return alpha; }
	public int getID(){ return id; }
	public Color getColor(){ return color; }
	
	public GUIElement hide(boolean state){ this.hidden = state; return this; }
	public GUIElement setRec(Rectangle rec){ this.rec = rec; return this; }
	public GUIElement setX(int x){ this.rec.x = x; return this; }
	public GUIElement setY(int y){ this.rec.y = y; return this; }
	public GUIElement setWidth(int width){ this.rec.width = width; return this; }
	public GUIElement setHeight(int height){ this.rec.height = height; return this; }
	public GUIElement setAlpha(float alpha){ this.alpha = alpha; return this; }
	public GUIElement setID(int id){ this.id = id; return this; }
	public GUIElement setColor(Color color){ this.color = color; return this; }
	
}
