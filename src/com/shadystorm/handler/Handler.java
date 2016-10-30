package com.shadystorm.handler;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.shadystorm.entities.GameObject;

//Makes the Handler final, because there is no need to change it
public final class Handler {
	
	//Create the list of all GameObjects
	public static List<GameObject> object = new ArrayList<GameObject>();

	//Makes the constructor private, so this class can't be instantiated
	private Handler(){}
	
	//The tick() method loops through all registered GameObjects and call their tick() methods
	public static void tick(){
		for(int i = 0; i < object.size(); i++){
			object.get(i).tick();
		}
	}
	
	//The render() method loops through all registered GameObjects and call their render() methods
	public static void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			object.get(i).render(g);
		}
	}
	
	//The registerObject() method registers an object in the GameObject list
	public static void registerObject(GameObject o){
		object.add(o);
	}
	
	//The removeObject() method removes an object from the GameObject list
	public static void removeObject(GameObject o){
		object.remove(o);
	}
	
	//The getObjectByID() method returns the GameObject on the list, wich matches the given id
	public static GameObject getObjectByID(int id){
		for(int i = 0; i < object.size(); i++){
			if(object.get(i).getID() == id) return object.get(i);
		}
		return null;
	}
	
	//The getNewID() method returns an unused id
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
	
}
