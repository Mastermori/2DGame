package com.shadystorm.handler;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import com.shadystorm.guielements.GUIElement;
import com.shadystorm.guielements.GUIType;
import com.shadystorm.libary.libMath;

public class GUIHandler extends MouseAdapter{
	
	public static List<GUIElement> object = new ArrayList<GUIElement>();
	
	public static void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			object.get(i).render(g);
		}
	}
	
	public static void registerObject(GUIElement o){
		object.add(o);
	}
	
	public static void removeObject(GUIElement o){
		object.remove(o);
	}
	
	public static GUIElement getObjectByID(int id){
		for(int i = 0; i < object.size(); i++){
			if(object.get(i).getID() == id) return object.get(i);
		}
		return null;
	}
	
	public static int getNewID(){
		int id = 1;
		boolean suc = true;
		while(true){
			for(int i = 0; i < object.size(); i++){
				if(id == object.get(i).getID()) suc = false;
			}
			if(suc)
				return id;
			id++;
			suc = true;
		}
	}
	
	public void mousePressed(MouseEvent e){
		for(int i = 0; i < object.size(); i++){
			if(object.get(i).getType() == GUIType.Button && !object.get(i).isHidden() && libMath.overlaping(new Rectangle(e.getX(), e.getY(), 1, 1), object.get(i).getRec())){
				object.get(i).press();
			}
		}
	}
	
}
