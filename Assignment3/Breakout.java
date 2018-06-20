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
	    numberRounds = NTURNS;
	    numberOfBricks = NBRICK_ROWS * NBRICKS_PER_ROW;
	    finished = new GLabel("You finished the Game");
	    gameOver = new GLabel("GAME OVER");
	    finished.setFont("London-36");
	    gameOver.setFont("London-36");
	    scoreLbl = new GLabel("SCORE: " + score);
	    add(scoreLbl, APPLICATION_WIDTH / 2 - scoreLbl.getWidth(), APPLICATION_HEIGHT - PADDLE_Y_OFFSET);
	    mouseClicked = 0;
	}
	
	/* Method: run() */
	/** Runs the Breakout program. */
	public void run() {
		setUpGame();
		startGame();
	}
	
	private void startBall() {
		if (mouseClicked < 1) {
			if (vy < 2) {
				vy += 3.0;
			}
			
			if (vx < 1) {
				vx = rgen.nextDouble(1.0, 3.0);
				if (rgen.nextBoolean(0.5)) vx = -vx;
			}
		}
	}
	private void startGame() {
		/* Create ball */
		ball = new GOval((APPLICATION_WIDTH / 2) - (BALL_RADIUS / 2 ), 
				(APPLICATION_HEIGHT / 2) - (BALL_RADIUS / 2 ),
				BALL_RADIUS, BALL_RADIUS);
		ball.setFilled(true);
		add(ball);

		while (true) {			
			ball.move(vx, vy);	
			pause(PAUSE_TIME);
			
			/* Checking if ball hits borders of screen */
			if (ball.getX() + BALL_RADIUS > APPLICATION_WIDTH) {
				vx = (vx > 0) ? -vx : vx;
				bounceClip.play();
			} else if (ball.getX() < 0) {
				vx = (vx > 0) ? vx : -vx;
				bounceClip.play();
			}
			if (ball.getY() + BALL_RADIUS > APPLICATION_HEIGHT - PADDLE_Y_OFFSET) {
				/* lower the rounds */
				numberRounds--;
				vx = 0;
				vy = 0;
				mouseClicked = 0;
				if (numberRounds > 0) {
					remove(ball);
					startGame();
				} else {
					/* GAME OVER */
					removeAll();
					double widthOfGO = gameOver.getWidth() / 2;
					add(gameOver, APPLICATION_WIDTH / 2 - widthOfGO, APPLICATION_HEIGHT / 2);
				}	
			} else if (ball.getY() < 0) {
				vy = (vy > 0) ? vy : -vy;
				bounceClip.play();
			}
			
			GObject collider = getCollidingObject();
			
			if (collider != null) {
				if (collider == paddle) {
					vy = (vy > 0) ? -vy : vy;
					
					/* bouncing off from edge of paddle */
					double paddleX = paddle.getX();
					double ballX = ball.getX();
					double contact = ballX - paddleX;
					if (contact > 0) {
						if (contact < PADDLE_WIDTH / 6) {
							vx = -vx;
						} else if (contact > (PADDLE_WIDTH / 6) * 5){
							vx = (vx > 0) ? vx : -vx;
						}
					}
					
					bounceClip.play();
					
					/* setting game harder */
					hitPaddle++;
					if (hitPaddle == 7) {
						vy -= 1.5;
					} else if (hitPaddle == 20) {
						vy -= 1.5;
					} else if (hitPaddle == 50) {
						vy -= 1.5;
					}
					
				} else {
					/* When ball hits brick */
					remove(collider);
					vy = (vy < 0) ? -vy : vy;
					bounceClip.play();
					numberOfBricks--;
					score += 50;
					scoreLbl.setLabel("Score: " + score);
					if (numberOfBricks < 1) {
						removeAll();
						double widthOfF = finished.getWidth() / 2;
						add(finished, APPLICATION_WIDTH / 2 - widthOfF, APPLICATION_HEIGHT / 2);
					}
				}
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
						BRICK_Y_OFFSET + (i * BRICK_HEIGHT) + BRICK_SEP * i, 
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
	
	private GObject getCollidingObject() {
		if (getElementAt(ball.getX(), 
				ball.getY()) != null) {
			return getElementAt(ball.getX(), 
					ball.getY());
		} else if (getElementAt(ball.getX(), 
				ball.getY() + (BALL_RADIUS)) != null) {
			return (getElementAt(ball.getX(), 
					ball.getY() + (BALL_RADIUS)));	
		} else if (getElementAt(ball.getX() + (BALL_RADIUS), 
				ball.getY()) != null) {
			return getElementAt(ball.getX() + (BALL_RADIUS), 
					ball.getY());		
		} else if (getElementAt(ball.getX() + (BALL_RADIUS),
				ball.getY() + (BALL_RADIUS)) != null) {
			return getElementAt(ball.getX() + (BALL_RADIUS),
					ball.getY() + (BALL_RADIUS));	
		}	
		return null;
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
	
	public void mouseClicked(MouseEvent e) {
		startBall();
		mouseClicked++;
	}
	
	public void mouseExited(MouseEvent e) {
		tempVX = vx;
		tempVY = vy;
		vy = 0;
		vx = 0;
	}
	
	public void mouseEntered(MouseEvent e) {
		vx = tempVX;
		vy = tempVY;
	}
	
	/* Instance variables */
	private GRect paddle;
	private GOval ball;
	private double vx, vy;
	private RandomGenerator rgen = new RandomGenerator();
	private int numberRounds;
	private int numberOfBricks;
	private GLabel gameOver;
	private GLabel finished;
	private AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");
	private int hitPaddle;
	private int score = 0;
	private int mouseClicked;
	private double tempVX, tempVY;
	private GLabel scoreLbl;
}
