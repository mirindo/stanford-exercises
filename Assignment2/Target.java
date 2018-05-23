/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	private static final double OUTER_CIRCLE = 72;
	private static final double WHITE_CIRCLE = 0.65 * OUTER_CIRCLE;
	private static final double INNER_CIRCLE = 0.3 * OUTER_CIRCLE;
	
//	(OUTER_CIRCLE / 2)
	public void run() {
		double centerOfCanvasX = (getWidth() / 2);
		double centerOfCanvasY =  (getHeight() / 2);
		GOval outerCircle = new GOval(centerOfCanvasX - OUTER_CIRCLE / 2 , centerOfCanvasY - OUTER_CIRCLE / 2, OUTER_CIRCLE, OUTER_CIRCLE);
		outerCircle.setColor(Color.RED);
		outerCircle.setFilled(true);
		outerCircle.setFillColor(Color.RED);
		add(outerCircle);
		
		GOval whiteCircle = new GOval(centerOfCanvasX - (WHITE_CIRCLE / 2), centerOfCanvasY - (WHITE_CIRCLE / 2), WHITE_CIRCLE, WHITE_CIRCLE);
		whiteCircle.setColor(Color.WHITE);
		whiteCircle.setFilled(true);
		whiteCircle.setFillColor(Color.WHITE);
		add(whiteCircle);
		
		GOval innerCircle = new GOval(centerOfCanvasX - (INNER_CIRCLE / 2), centerOfCanvasY - (INNER_CIRCLE / 2), INNER_CIRCLE, INNER_CIRCLE);
		innerCircle.setColor(Color.RED);
		innerCircle.setFilled(true);
		innerCircle.setFillColor(Color.RED);
		add(innerCircle);
		
		/* You fill this in. */
	}
}
