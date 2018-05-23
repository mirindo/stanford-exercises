/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int WIDTH = 30;

/** Width of each brick in pixels */
	private static final int HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		/* You fill this in. */
		//getWidth
		//label.getWidth
		int startingPositionX = (getWidth() / 2) - ((BRICKS_IN_BASE / 2) * 30);
		int startingPositionY = (getHeight() - HEIGHT);
		int numberOfBricksHor = BRICKS_IN_BASE;
		int numberOfBricksVert = BRICKS_IN_BASE;
		
		for (int i = 0; i <= numberOfBricksVert; i++) {
			for (int j = 0; j <= numberOfBricksHor; j++) {
				add(new GRect(startingPositionX + (j * WIDTH) + ((i * WIDTH) / 2), startingPositionY - (i * HEIGHT), WIDTH, HEIGHT));
			}
			numberOfBricksHor--;
		}
	}
}
