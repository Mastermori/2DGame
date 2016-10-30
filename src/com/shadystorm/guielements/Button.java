package com.shadystorm.guielements;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.function.Consumer;

import com.shadystorm.main.Main;

public class Button extends GUIElement{
	
	private Font font;
	
	//WORK ON THIS!!!
	public Button(Rectangle rec, String value){
		super(rec, GUIType.Button);
		this.value = value;
		this.color = Main.backgroundColor;
	}
	//WORK ON THIS!!!
	
	public void render(Graphics g){
		int strWidth = (int)g.getFontMetrics().getStringBounds(value, g).getWidth();
		g.setColor(color);
		g.drawString(value, rec.x + rec.width/2 - strWidth/2, rec.y + rec.height/2);
		g.drawRect(rec.x, rec.y, rec.width, rec.height);
	}
	
	public String getValue(){ return value; }
	public Font getFont(){ return font; }
	
	public Button setValue(String value){ this.value = value; return this; }
	public Button setFont(Font font){ this.font = font; return this; }
	
}
