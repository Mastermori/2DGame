package com.shadystorm.envroiment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.shadystorm.libary.Draw;

public class Floor {
	
	private int x, y;
	private int width, height;
	private Color color;
	private float alpha;
	private int id;
	private EnvroimentType type;
	
	public Floor(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = Color.BLACK;
		this.alpha = 1f;
	}
	
	public void render(Graphics g){
		Draw.rectangle(g, color, new Rectangle(x, y, width, height), alpha);
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public Color getColor(){
		return color;
	}
	public float getAlpha(){
		return alpha;
	}
	public int getID(){
		return id;
	}
	
	public Floor setX(int x){
		this.x = x;
		return this;
	}
	public Floor setY(int y){
		this.y = y;
		return this;
	}
	public Floor setWidth(int width){
		this.width = width;
		return this;
	}
	public Floor setHeight(int height){
		this.height = height;
		return this;
	}
	public Floor setColor(Color color){
		this.color = color;
		return this;
	}
	public Floor setAlpha(float alpha){
		this.alpha = alpha;
		return this;
	}
	public Floor setID(int id){
		this.id = id;
		return this;
	}
}
