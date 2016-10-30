package com.shadystorm.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.util.Random;

import com.shadystorm.entities.Particle;
import com.shadystorm.entities.Player;
import com.shadystorm.gamestate.GameState;
import com.shadystorm.gamestate.GameStateManager;
import com.shadystorm.guielements.Button;
import com.shadystorm.handler.GUIHandler;
import com.shadystorm.handler.Handler;
import com.shadystorm.libary.Draw;
import com.shadystorm.libary.KeyInput;
import com.shadystorm.window.Window;

public class Main extends Canvas implements Runnable{
	
	//Dynamic generated serialVersionUID
	private static final long serialVersionUID = 8827367025612378153L;
	
	//Sets the width and height for the Window
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 *9;
	public static final Color backgroundColor = Color.WHITE;
	
	//Creates the Thread and initializes the running boolean
	private Thread thread;
	private boolean running = false;
	
	//Creates a Random object for randomization
	private Random r;
	
	//Creates the Player and a second Player for testing purposes
	private static Player player;
	private static Player player2;
	
	//Initializes the particle timer variables
	int particleTimer = 10;
	int particleMax = particleTimer;
	
	//Main constructor
	public Main(){
		//Creates the Window and adds a KeyListener to the Canvas
		new Window(WIDTH, HEIGHT, "2D Game", this);
		this.addKeyListener(new KeyInput());
		this.addMouseListener(new GUIHandler());
		
		//Initializes created objects
		r = new Random();
		
		GameStateManager.setGameState(GameState.MainMenu);
		
		GUIHandler.registerObject(new Button(new Rectangle(100, 100, 200, 50), "Test").setColor(Color.BLACK).hide(false));
		
	}
	
	public static void startRound1(){
		//Initializes player and player2
		player = new Player(new Rectangle(100, 100, 50, 50));
		player2 = new Player(new Rectangle(150, 100, 50, 50));
		//Adds the initialized GameObjects to the handler
		Handler.registerObject(player.setID(1));
		Handler.registerObject(player2.setID(2).setColor(Color.RED));
	}
	
	//The start() method is used to start the main thread
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	//The stop() method is used to stop the main thread
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			System.err.println("Failed to stop the thread: " + thread);
			e.printStackTrace();
		}
	}
	
	//The run() method is used to start the gameloop
	public void run(){
		//Initializes the gameloop variables
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		//The gameloop wich calls the tick() method every gameTick (60 times/sec) and the render() method each frame (dependent on System)
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				//Counts and prints the FPS
				timer += 1000;
				Window.setTitle("2D Game           FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	//The tick() method is used to cast the magic behind the game
	private void tick(){
		if(GameStateManager.getGameState() == GameState.InGame){
			tickInGame();
		}else if(GameStateManager.getGameState() == GameState.MainMenu){
			
		}
	}
	
	//The tick() method is called by tick() when you are InGame
	private void tickInGame(){
		//Particle system
		if(particleTimer <= 0){
			//Adds a trail of particles to player1
			Handler.registerObject(new Particle(player, r.nextFloat() * (4.5f - 2f) + 2f, r.nextFloat() * (5 + 5) - 5, r.nextFloat() * (5 + 5) - 5));
			particleTimer = particleMax;
		}else{
			particleTimer -= 1;
		}
		//Calls the tick method of all registered game objects
		Handler.tick();
	}
	
	//The render() method is used to print the visuals to the screen
	private void render(){
		//Initializes the BufferStrategy (3 dimensional)
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		//Initializes the Graphics object from the BufferStrategy
		Graphics g = bs.getDrawGraphics();
		
		//Fills the background of the entire canvas black
		g.setColor(backgroundColor);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		GUIHandler.render(g);
		
		if(GameStateManager.getGameState() == GameState.InGame){
			renderInGame(g);
		}else if(GameStateManager.getGameState() == GameState.MainMenu){
			renderMainMenu(g);
		}
		
		//Disposes of the graphics object and shows the printed on BufferStrategy
		g.dispose();
		bs.show();
	}
	
	private void renderInGame(Graphics g){
		//Calls the render method of all registered game objects
		Handler.render(g);
	}
	
	private void renderMainMenu(Graphics g){
		
	}
	
	//The Main method, called from Java
	public static void main(String[] args) {
		
		//Creates an instance of this class, calling the constructor
		new Main();
		
	}
	
	//Getter for the player
	public static Player getPlayer(){
		return player;
	}

}
