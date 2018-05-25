/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	
	private static final double CLASS_BOX_WIDTH = 100;
	private static final double CLASS_BOX_HEIGHT = 50;
	
	
	public void run() {
		
		double centerWidth = getWidth() / 2;
		double centerHeight = getHeight() / 2;
		double halfOfClassBoxWidth = CLASS_BOX_WIDTH / 2;
		double halfOfClassBoxHeight = CLASS_BOX_HEIGHT / 2;
		double gapBetweenClassBox = 15.00;
		
		
		// Program 
		GRect programRect = new GRect(centerWidth + halfOfClassBoxWidth, centerHeight / 2, CLASS_BOX_WIDTH, CLASS_BOX_HEIGHT);
		GLabel programLabel = new GLabel("Program", centerWidth - halfOfClassBoxWidth, centerHeight / 2 + halfOfClassBoxHeight);
		
		double centerWidthProgramLabel = programLabel.getWidth() / 2;
		double centerHeightProgramLabel = programLabel.getAscent() / 2;
		
		programLabel.move(centerWidthProgramLabel, centerHeightProgramLabel);
		add(programLabel);
		add(programRect);
		
		//GrapgicsProgram
		GRect graphicRect = new GRect(gapBetweenClassBox * 2, centerHeight, CLASS_BOX_WIDTH, CLASS_BOX_HEIGHT);
	
		GLabel graphicLabel = new GLabel("Graphic Program", 0, centerHeight + halfOfClassBoxHeight);
		double centerWidthGraphicLabel = graphicLabel.getWidth() / 2;
		double centerHeightGraphicLabel = graphicLabel.getAscent() / 2;
		graphicLabel.move(centerWidthGraphicLabel, centerHeightGraphicLabel);
		add(graphicRect);
		add(graphicLabel);
		
		//
	}
	
//	public double center
}

