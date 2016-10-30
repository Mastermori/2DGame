package com.shadystorm.window;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.shadystorm.main.Main;

//The Window class is the Window wich will open on start
@SuppressWarnings("serial")
public class Window extends Canvas{
	
	//Creates the frame (JFrame)
	static JFrame frame;
	
	//The Constructor of the Window, specifies it's properties
	public Window(int width, int height, String title, Main main){
		//Sets the title of the Window
		frame = new JFrame(title);
		
		//Sets the Window size
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		//Sets the remaining properties
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(main);
		frame.setVisible(true);
		main.start();
		
	}
	
	//Setter for the title
	public static void setTitle(String title){
		frame.setTitle(title);
	}
	
}
