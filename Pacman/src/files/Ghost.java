package edu.nyu.cs.zh975.PacmanAssignment;
import edu.nyu.cs.zh975.PacmanAssignment.TestPac;
import processing.core.PImage;

/**
 * This class represents a ghost. 
 * Eric and Tariq each represents a ghost. 
 * @author Eric He
 * @author Tariq Abubakr
 * @version 1.0
 */
public class Ghost {
	
	TestPac app;
	
	private final static String ERIC_IMAGE_PATH = "eric.png"; 
	private final static String TARIQ_IMAGE_PATH = "tariq.png"; 
	private PImage img; 
	
	private int x,y;                //x and y coordinates of the ghosts. 
	private int speedXT = 4; 		//x speed of ghost Tariq. 
	private int speedYT = 0; 		//y speed of ghost Tariq.
	private int speedXE = 0; 		//x speed of ghost Eric. 
	private int speedYE = 4;		//y speed of ghost Eric. 
	
	/**
	 * Constructor for ghost Eric. 
	 * @param app
	 */
	
	public Ghost(TestPac app) {		
		
		this.app = app;
		this.x = TestPac.APP_MARGIN; 
		this.y = TestPac.APP_MARGIN;
		
		this.img = this.app.loadImage(Ghost.ERIC_IMAGE_PATH);
		img.resize(50, 60);
	}
	
	/**
	 * Constructor for ghost Tariq. 
	 * @param app 
	 * @param name name of the ghost
	 */
	
	public Ghost(TestPac app, String name) {
		 
		this.app = app;
		this.x = TestPac.APP_MARGIN + 700;
		this.y = TestPac.APP_MARGIN + 300;
		this.img = this.app.loadImage(Ghost.TARIQ_IMAGE_PATH);
		name = "Tariq";
		img.resize(50, 60);
	}
	
	/**
	 * @return the width of the image
	 */

	public int getWidth() {
		return this.img.width;
	}
	
	/**
	 * @return the height of the image
	 */

	public int getHeight() {
		return this.img.height;
	}

	/**
	 * Set the x and y speed for Eric and Tariq. 
	 * @param xE Eric's speed in x direction. 
	 * @param yE Eric's speed in y direction. 
	 * @param xT Tariq's speed in x direction. 
	 * @param yT Tariq's speed in y direction. 
	 */
	
	public void setSpeed(int xE, int yE, int xT, int yT) {
		this.speedXE = xE;
		this.speedYE = yE;
		this.speedXT = xT;
		this.speedYT = yT;
		
	}

	/*
	 * This method draws ghost. 
	 */
	
	public void draw() {
		this.app.image(this.img, this.x, this.y);
	}
	
	/*
	 * This method sets the path for ghost Tariq by creating movement boundaries. 
	 */
	
	public void moveTariq() {
		this.x = this.x - this.speedXT;
		this.y = this.y - this.speedYT;

		boolean outOfBoundsToTheLeft = this.x < 40;
		boolean outOfBoundsToTheRight = this.x >  this.app.width - this.getWidth() - TestPac.APP_MARGIN; 
		boolean outOfBoundsToTheTop = this.y < 160;
		boolean outOfBoundsToTheBottem = this.y > this.app.height - this.getHeight() - TestPac.APP_MARGIN;
	
		if (outOfBoundsToTheLeft) {
			this.speedXT = 0;
			this.speedYT = 4;
			this.x = 40;
		}
		if (outOfBoundsToTheTop) {
			this.speedYT = 0;
			this.speedXT = -4;
			this.y = 160;
		}
	    if (outOfBoundsToTheRight) {
			this.speedXT = 0;
			this.speedYT = -4;
			this.x = this.app.width - this.getWidth() - TestPac.APP_MARGIN; ;
		
		}
		if (outOfBoundsToTheBottem) {
			this.speedXT = 4;
			this.speedYT = 0;
			this.y = this.app.height - this.getHeight() - TestPac.APP_MARGIN;

		}
	}
	
	/*
	 * This method sets the path for ghost Eric by creating movement boundaries. 
	 */
	
	public void moveEric() {
		this.x = this.x - this.speedXE;
		this.y = this.y + this.speedYE;

		boolean outOfBoundsToTheLeft = this.x <  TestPac.APP_MARGIN;
		boolean outOfBoundsToTheRight = this.x >  this.app.width - this.getWidth() - TestPac.APP_MARGIN; 
		boolean outOfBoundsToTheTop = this.y < TestPac.APP_MARGIN;
		boolean outOfBoundsToTheBottem = this.y > 220 - this.getHeight();
	
		if (outOfBoundsToTheLeft) {
			this.speedXE = 0;
			this.speedYE = 4;
			this.x = TestPac.APP_MARGIN;
		}
		if (outOfBoundsToTheBottem) {
			this.speedYE = 0;
			this.speedXE = -4;
			this.y = 220-this.getHeight() ;
		}
	    if (outOfBoundsToTheRight) {
			this.speedXE = 0;
			this.speedYE = -4;
			this.x = this.app.width - this.getWidth() - TestPac.APP_MARGIN;
		
		}
		if (outOfBoundsToTheTop) {
			this.speedXE = 4;
			this.speedYE = 0;
			this.y = TestPac.APP_MARGIN;

		}
	}
	
	/**
	 * This class detects collision between ghost and Pac-man. 
	 * @param pacman
	 * @return boolean value of whether collision is true. 
	 */
	
	public boolean ghostCollision(Pacman pacman) {
		boolean ghostCollision = false;
		boolean isOutLeftBound = x <= pacman.getX() + pacman.getWidth();
		boolean isOutRightBound = x + this.getWidth() >= pacman.getX();
		boolean isOutTopBound = y <= pacman.getY() + pacman.getHeight();
		boolean isOutBottemBound = y + this.getHeight() >=pacman.getY();
		
		if (isOutLeftBound && isOutRightBound && isOutTopBound && isOutBottemBound) {
			ghostCollision = true;
			
		}
		return ghostCollision;
	}
	
	
}
