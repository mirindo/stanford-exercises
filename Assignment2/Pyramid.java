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
		
		for (int c = BRICKS_IN_BASE; c > 0; c--) {
			for (int i = c; i > 0; i--) {
				add(new GRect(100 +  (WIDTH * i), 100 , WIDTH, HEIGHT));
			}
		}
	}
}
