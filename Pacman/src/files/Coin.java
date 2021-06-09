package files;
import processing.core.PImage;

/**
 * This class represents a coin. 
 * @author Eric He
 * @author Tariq Abubakr
 * @version 1.0
 */
public class Coin {
	
	TestPac app;
	
	private final static String COIN_IMAGE_PATH  = "coin.png"; 
	private PImage img;
	
	
	public int x, y;  //x and y coordinates of the coins. 
	
	/**
	 * Constructor for coins
	 * @param x x-coordiates for the coin
	 * @param y y-coordiates for the coin
	 * @param app
	 */
	
	public Coin(int x, int y, TestPac app) {
		this.x = x;
		this.y = y;
		this.app = app;
		
		this.img = app.loadImage(COIN_IMAGE_PATH);
		img.resize(40, 40);	
	}

	/*
	 * Get width of the coin
	 */

	public int getWidth() {
		return this.img.width;
	}
	
	/*
	 * Get height of the coin
	 */
	
	public int getHeight() {
	return this.img.height;
	}
	
	
	/*
	 * Draw the coin
	 */
	
	public void draw() {
		this.app.image(this.img, this.x, this.y);
	}
	
	/*
	 * Sets the position of the coin
	 */
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/*
	 * This method removes the coin from the coin arrayList
	 */
	
	public void Eaten() {
		this.app.getCoin().remove(this);
		TestPac.SCORE ++;
	}
	
	/**
	 * This method detects collision betweeen coin and pacman.
	 * @param pacman pacman from Pacman class.
	 * @return boolean value of whether collision happened. 
	 */
	
	public boolean coinColllision(Pacman pacman) {
		
		boolean coinCollision = false;
		boolean isOutLeftBound = x <= pacman.getX() + pacman.getWidth();
		boolean isOutRightBound = x + this.getWidth() >= pacman.getX();
		boolean isOutTopBound = y <= pacman.getY() + pacman.getHeight();
		boolean isOutBottemBound = y + this.getHeight() >=pacman.getY();
		
		if (isOutLeftBound && isOutRightBound && isOutTopBound && isOutBottemBound) {
			coinCollision = true;
			
		}
		return coinCollision;

	}
	
}
