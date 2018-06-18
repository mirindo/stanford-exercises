/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

	private static final double PAUSE_TIME = 10.0;

	/* Method init to set the dimensions of the canvas */
	public void init() {
	    setSize(APPLICATION_WIDTH + BRICK_SEP, APPLICATION_HEIGHT);
	}
	
	/* Method: run() */
	/** Runs the Breakout program. */
	public void run() {

		setUpGame();
		startGame();
		
		
	}
	
	private void startGame() {
		/* Create ball */
		ball = new GOval((APPLICATION_WIDTH / 2) - (BALL_RADIUS / 2 ), 
				(APPLICATION_HEIGHT / 2) - (BALL_RADIUS / 2 ),
				BALL_RADIUS, BALL_RADIUS);
		ball.setFilled(true);
		add(ball);
		
		vy = 3.0;

		vx = rgen.nextDouble(1.0, 3.0);
		if (rgen.nextBoolean(0.5)) vx = -vx;
		
		border = new GRect(0,0,APPLICATION_WIDTH,APPLICATION_HEIGHT - BRICK_SEP);
		add(border);
		
		while (true) {			
			ball.move(vx, vy);	
			pause(PAUSE_TIME);
			
			/* Checking if ball hits borders of screen */
			if (ball.getX() + BALL_RADIUS > APPLICATION_WIDTH) {
				vx = (vx > 0) ? -vx : vx;
			} else if (ball.getX() < 0) {
				vx = (vx > 0) ? vx : -vx;
			}
			if (ball.getY() + BALL_RADIUS > APPLICATION_HEIGHT) {
				vy = (vy > 0) ? -vy : vy;
			} else if (ball.getY() < 0) {
				vy = (vy > 0) ? vy : -vy;
			}
			
			collider = getCollidingObject();
			
			if (collider == paddle) {
					vy = (vy > 0) ? -vy : vy;
			}
		}
		
		
		
	}
	
	private void setUpGame() {
		/* Mouse listeners to get the position of mouse */
		addMouseListeners();
		
		/* Create color blocks */
		for (int i = 0; i < NBRICK_ROWS; i++) {
			for (int j = 0; j < NBRICKS_PER_ROW; j++) {
				
				GRect brick = new GRect((j * BRICK_WIDTH) + BRICK_SEP * j + BRICK_SEP, 
						PADDLE_Y_OFFSET + (i * BRICK_HEIGHT) + BRICK_SEP * i, 
						BRICK_WIDTH, BRICK_HEIGHT);
				brick.setFilled(true);
				if ((i == 0) || (i == 1)) {
					brick.setFillColor(Color.RED);
				} else if ((i == 2) || (i == 3)) {
					brick.setFillColor(Color.ORANGE);
				} else if ((i == 4) || (i == 5)) {
					brick.setFillColor(Color.YELLOW);
				} else if ((i == 6) || (i == 7)) {
					brick.setFillColor(Color.GREEN);
				} else {
					brick.setFillColor(Color.CYAN);
				}
				add(brick);
			}
		}
		
		/* Create paddle object */
		paddle = new GRect(APPLICATION_WIDTH / 2 - PADDLE_WIDTH / 2,
				APPLICATION_HEIGHT - PADDLE_HEIGHT - PADDLE_Y_OFFSET,
				PADDLE_WIDTH, PADDLE_HEIGHT );
		paddle.setFilled(true);
		add(paddle);
	}

	/* Moving with mouse and repositioning paddle */
	
	public void mouseMoved(MouseEvent e) {
		double positionXLeft = e.getX() - PADDLE_WIDTH / 2 ;
		double positionXRight = e.getX() + PADDLE_WIDTH / 2 ;
		
		/* checking if paddle reached sides of canvas */
		if (positionXRight > APPLICATION_WIDTH)  {
			paddle.setLocation(APPLICATION_WIDTH - (paddle.getWidth()), paddle.getY());
		} else if (positionXLeft < 0) {
			paddle.setLocation(0, paddle.getY());
		} else {
			
		/* moving paddle with mouse */
		paddle.setLocation(e.getX() - (paddle.getWidth() / 2), paddle.getY());
		}
	}
	
	private GObject getCollidingObject() {
		if (getElementAt(ball.getX(), 
				ball.getY()) != null) {
			return getElementAt(ball.getX(), 
					ball.getY());
			
		} else if (getElementAt(ball.getX(), 
				ball.getY() + (2 * BALL_RADIUS)) != null) {
			return (getElementAt(ball.getX(), 
					ball.getY() + (2 * BALL_RADIUS)));
			
		} else if (getElementAt(ball.getX() + (2 * BALL_RADIUS), 
				ball.getY()) != null) {
			return getElementAt(ball.getX() + (2 * BALL_RADIUS), 
					ball.getY());
			
		} else if (getElementAt(ball.getX() + (2 * BALL_RADIUS),
				ball.getY() + (2 * BALL_RADIUS)) != null) {
			return getElementAt(ball.getX() + (2 * BALL_RADIUS),
					ball.getY() + (2 * BALL_RADIUS));
			
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* Instance variable of the paddle */
	private GRect paddle;
	private GOval ball;
	private double vx, vy;
	private RandomGenerator rgen = new RandomGenerator();
	private GRect border;
	private GObject collider;
	
}
