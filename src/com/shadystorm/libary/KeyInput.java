package com.shadystorm.libary;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.shadystorm.handler.Handler;
import com.shadystorm.handler.Type;
import com.shadystorm.main.Main;

public class KeyInput implements KeyListener{
	
	//The keyPressed() method is called on each keystroke
	@Override
	public void keyPressed(KeyEvent e){
		//Runs the specified action for the pressed key/keys
		if(e.getKeyCode() == 32){		//When space is pressed, jump once
			Main.getPlayer().jump();
		}else if(e.getKeyCode() == 38){		//When the up arrow is pressed, go up
			Main.getPlayer().up(true);
		}else if(e.getKeyCode() == 37){		//When the left arrow is pressed, go left
			Main.getPlayer().left(true);
		}else if(e.getKeyCode() == 40){		//When the down arrow is pressed, go down
			Main.getPlayer().down(true);
		}else if(e.getKeyCode() == 39){		//When the right arrow is pressed, go right
			Main.getPlayer().right(true);
		}
	}
	
	//The keyReleased() method is called whenever a key is released
	@Override
	public void keyReleased(KeyEvent e){
		//Runs the specified action for the released key/keys
		if(e.getKeyCode() == 38){		//When the up arrow is released, stop going up
			Main.getPlayer().up(false);
		}else if(e.getKeyCode() == 37){		//When the left arrow is released, stop going left
			Main.getPlayer().left(false);
		}else if(e.getKeyCode() == 40){		//When the down arrow is released, stop going down
			Main.getPlayer().down(false);
		}else if(e.getKeyCode() == 39){		//When the right arrow is released, stop going right
			Main.getPlayer().right(false);
		}
	}
	
	//The keyTyped() mehtod is called on each type of a key
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
