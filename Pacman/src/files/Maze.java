package edu.nyu.cs.zh975.PacmanAssignment;

/**
 * This class reprents a singular maze block. 
 * @author Eric
 * @author Tariq Abubakr
 * @version 1.0
 */
public class Maze {
	
	TestPac app;
	
	private int x,y,width,height;
	
	/**
	 * Constructor 1
	 * @param app	  PApplet
	 * @param x		  x position of the maze
	 * @param y		  y position of the maze
	 * @param width   width of the maze 
	 * @param height  height of the maze
	 */
	public Maze(TestPac app, int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.app = app;
		this.width = width;
		this.height = height;
		
		
	}
	
	/**
	 * Constructor 2 
	 * @param app	 PApplet
	 * @param x		 x position of the maze
	 * @param y		 y position of the maze
	 */
	
	public Maze(TestPac app, int x, int y) {
		this(app, x ,y, 1, 1);
	}
	
	/**
	 * Constructor 3
	 * @param app PApplet/
	 */
	
	public Maze(TestPac app) {
		this(app,100,100,600,50);
	}
	
	/*
	 * Draws the maze. 
	 */
	
	public void draw() {
		this.app.fill(255,255,255);
		this.app.rect(x,y,width,height);
	}

	/**
	 * Detects whether the pacman collides with the maze. 
	 * @param pacman
	 * @return the boolean values of whether collision happens. 
	 */
	
	public boolean mazeColllision(Pacman pacman) {
		boolean mazeCollision = false;
		boolean isOutLeftBound = x <= pacman.getX() + pacman.getWidth();
		boolean isOutRightBound = x + width >= pacman.getX();
		boolean isOutTopBound = y <= pacman.getY() + pacman.getHeight();
		boolean isOutBottemBound = y + height >=pacman.getY();
		
		if (isOutLeftBound && isOutRightBound && isOutTopBound && isOutBottemBound) {
			mazeCollision = true;
			
		}
		return mazeCollision;
	}
	

}
