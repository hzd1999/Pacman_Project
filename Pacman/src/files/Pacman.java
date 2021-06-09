package files;
import files.TestPac;
import processing.core.PImage;

/**
 * This class represents a Pacman
 * @author Eric
 * @author Tariq Abubakr
 * @version 1.0
 */

public class Pacman {
	
	TestPac app;
	
	private final static String PACMAN_IMAGE_PATH = "pacman.png"; 
	private PImage img; 
	
	protected int x, y;      //x and y position of the pacman. 
	protected int pX, pY;    //previous x and previous y for boundary purposes. 
	private int speedX = 25; //Pacman speed in x direction.
	private int speedY = 25; //Pacman speed in y direction.
	
	
	public Pacman(TestPac app) {		
		
		this.app = app;					
		this.x = this.app.width/2; 
		this.y = this.app.height/2 - 40;
		
		this.img = this.app.loadImage(Pacman.PACMAN_IMAGE_PATH);
		img.resize(50, 50);
	}
	
	/*
	 * Get the x position of Pac-man.
	 */
	
	public int getX() {
		return this.x;
	}
	
	/*
	 * Get the y position of Pac-man.
	 */
	
	public int getY() {
		return this.y;
	}
	
	/*
	 * Get the width of Pac-man.
	 */
	
	public int getWidth() {
		return this.img.width;
	}
	
	/*
	 * Get the height of Pac-man.
	 */

	public int getHeight() {
		return this.img.height;
	}
	
	/*
	 * Sets the x and y speed for Pac-man
	 */
	
	public void setSpeed(int speedX, int speedY) {
		this.speedX = speedX;
		this.speedY = speedY;
	}
	
	/*
	 * Draws Pac-man
	 */

	public void draw() {
		this.app.image(this.img, this.x, this.y);
	}

	/*
	 * Allows Pac-man to go right within the boundary of the map. 
	 */
	
	public void goRight() {
		
		this.pX = this.x;
		this.pY = this.y;
		
		this.x = this.x + Math.abs(this.speedX);
		
		boolean isTooFarRight = this.x >  this.app.width - this.getWidth() - TestPac.APP_MARGIN; 
		
		if (isTooFarRight) {
			this.x = this.pX;
		}
	}

	/*
	 * Allows Pac-man to go left within the boundary of the map. 
	 */
	
	
	public void goLeft() {

		this.pX = this.x;
		this.pY = this.y;
		
		this.x = this.x - Math.abs(this.speedX);
		
		boolean isTooFarLeft = this.x < 0  + TestPac.APP_MARGIN;
		
		if (isTooFarLeft) {
			this.x = this.pX;
		}	
	}

	/*
	 * Allows Pac-man to go up within the boundary of the map. 
	 */
	
	
	public void goUp() {
		
		this.pX = this.x;
		this.pY = this.y;
		
		this.y = this.y - Math.abs(this.speedY);
		//check bounds
		boolean isTooFarUp = this.y < 0 + this.getHeight() - TestPac.APP_MARGIN;

		if (isTooFarUp) {
			y = this.pY;
		}
			
	}
	
	/*
	 * Allows Pac-man to go down within the boundary of the map. 
	 */
	
	
	public void goDown() {
		
		this.pX = this.x;
		this.pY = this.y;
		
		this.y = this.y + Math.abs(this.speedY);
		
		boolean isTooFarDown = this.y > this.app.height - this.getHeight() - TestPac.APP_MARGIN;

		if (isTooFarDown) {
			y = this.pY;
		}
		
	}
	

	
}
