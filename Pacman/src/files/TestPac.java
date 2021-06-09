package files;
import processing.core.PApplet;
import processing.core.PConstants;
import java.util.ArrayList;
import files.Ghost;
import files.Pacman;

/**
 * Basic controller for Pacman containing the basic business logic of the game.
 * @author Eric He
 * @author Tariq Abubakr
 * @version 1.0
 */

public class TestPac extends PApplet{

	public static void main(String[] args) {
	PApplet.main("edu.nyu.cs.zh975.PacmanAssignment.TestPac");
	}
	
	private final int w = 800;  //width of the window.
	private final int h = 400;	//height of the window.
	
	
	public final int BLACK = this.color(0,0,0);
	public final int WHITE = this.color(255,255,255);
	
	
	public final static int APP_MARGIN = 20; 	//Integer for boundary purpose
	public final static int NUM_COINS = 10; 	//There are 10 coins in total. 
	public static int SCORE = 0;
	
	
	private Pacman pacman;
	private Ghost[] ghost; 
	private Maze[] maze;
	private ArrayList<Coin> coins = new  ArrayList<Coin>();
	
	/**
	 * Getter method for coin. 
	 * @return ArrayList of coin objects. 
	 */
	
	public ArrayList<Coin> getCoin() {
		return this.coins;
	}
	

	public void settings() {
		this.size(this.w, this.h); //set window size		
	}
	
	
	public void setup() {

		this.pacman = new Pacman(this); 
		this.maze = new Maze[2];
		this.ghost = new Ghost[2];
		maze[0] = new Maze(this);
		maze[1] = new Maze(this,100,230,600,50);
		ghost[0]= new Ghost(this);
		ghost[1]= new Ghost(this, "Tariq");
		
		
		/**
		 * Position the coins.
		 */
		
		for (int i=0; i<TestPac.NUM_COINS; i++) {
			switch(i){
				case 0:
					Coin coin0 = new Coin(150 , 35, this);
					this.coins.add(coin0); 
				case 1:
					Coin coin1 = new Coin(350 , 35, this);
					this.coins.add(coin1);
				case 2:
					Coin coin2 = new Coin(550 , 35, this);
					this.coins.add(coin2);
				case 3:
					Coin coin3 = new Coin(730 , 35, this);
					this.coins.add(coin3);	
				case 4:
					Coin coin4 = new Coin(50 , 170, this);
					this.coins.add(coin4);	
				case 5:
					Coin coin5 = new Coin(250 , 170, this);
					this.coins.add(coin5);	
				case 6:
					Coin coin6 = new Coin(550 , 170, this);
					this.coins.add(coin6);
				case 7:
					Coin coin7 = new Coin(730 , 170, this);
					this.coins.add(coin7);	
				case 8:
					Coin coin8 = new Coin(50 , 320, this);
					this.coins.add(coin8);	
				case 9:
					Coin coin9 = new Coin(250 , 320, this);
					this.coins.add(coin9);	
				case 10:
					Coin coin10 = new Coin(550 , 320, this);
					this.coins.add(coin10);	
			}
		
		}
		
	}
	
		
		
	public void draw() {
		
		background(BLACK);
		
		//Score increases by a random number when pacman eats a coin. 
		text("Score:", 20,380);
		text(SCORE, 60, 380);
		
		//draw pacman
		this.pacman.draw();
		

		/**
		 * Draw coins;
		 */
		
		for (int i = 0; i < this.coins.size(); i++) {
			Coin coin = this.coins.get(i);
			coin.draw();
		}
		
		/*
		 * Create a coinsToRemove list and add removed coins to it.
		 */
		
		ArrayList<Coin> coinsToRemove = new  ArrayList<Coin>(); 
	
		for (Coin coin: this.coins) {
			if (coin.coinColllision(pacman)) {
				coinsToRemove.add(coin);
			}	
		}
		
		/*
		 * Loop through the removed coins and remove them from the orginal arraylist
		   through method Eaten from coin class. 
		 */
		
		for (Coin coin : coinsToRemove) {
			coin.Eaten();
		}
		
		/**
		 * If all coins are collected. User wins.
		 * All obejects speed set to 0.
		 */
		
		if (this.coins.size() == 0) {
			pacman.setSpeed(0, 0);
			ghost[0].setSpeed(0,0,0,0);
			ghost[1].setSpeed(0,0,0,0);
			text("Congratulations! You Win." , 330, 200);
		}
	
	
		
		/**
		 * Loop through the ghosts and draw ghost. 
		 */
		
		for (int i = 0; i < ghost.length; i++) {

			if (this.ghost[i] == this.ghost[0]) {
				this.ghost[i].moveEric();
				this.ghost[i].draw();
			}
			if (this.ghost[i] == this.ghost[1]) {
				this.ghost[i].moveTariq();
				this.ghost[i].draw();
			}
		}
		
		/*
		 * If ghost collides with Pac-man, game over! All obejects speed set to 0.
		 */
		
		for (int i = 0; i < ghost.length; i ++) {	
			if (ghost[i].ghostCollision(pacman)) {
				pacman.setSpeed(0,0);
				ghost[0].setSpeed(0,0,0,0);
				ghost[1].setSpeed(0,0,0,0);
				text("GAME OVER" , 380, 200);
			}
		}
		
		/*
		 * This method draws the maze. 
		 */
		
		for (int i = 0; i < maze.length; i ++) {
			this.maze[i].draw();
		}
		
		/*
		 * This method sets the Pac-man back to its previous position when 
		   it reaches the maze boundaries. 
		 */
		
		for (Maze maze : this.maze) {
			if (maze.mazeColllision(pacman)) {
				pacman.x = pacman.pX;
				pacman.y = pacman.pY;
			}
		}
		

	}
	
	/*
	 * (non-Javadoc)
	 * @see processing.core.PApplet#keyPressed()
	 */
	
	public void keyPressed() {
		
		if (this.key == PConstants.CODED) {
			switch (this.keyCode) {
				case PConstants.LEFT:
					this.pacman.goLeft();	
					break;
				case PConstants.RIGHT:
					this.pacman.goRight();
					break;
				case PConstants.UP:
					this.pacman.goUp();
					break;
				case PConstants.DOWN:
					this.pacman.goDown();
					break;
			}
				
		}
	
	}
	
	

}

