package com.shadystorm.gamestate;

public class GameStateManager {
	
	private static GameState gameState;
	
	public static GameState getGameState(){ return gameState; }
	public static void setGameState(GameState gs){ gameState = gs; }
	
}
