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
		
		
		// Program 
		GRect programRect = new GRect(centerWidth - halfOfClassBoxWidth, centerHeight / 3, CLASS_BOX_WIDTH, CLASS_BOX_HEIGHT);
		GLabel programLabel = new GLabel("Program", centerWidth - halfOfClassBoxWidth, centerHeight / 3);
		
		double centerWidthProgramLabel = (programRect.getWidth() - programLabel.getWidth()) / 2;
		double centerHeightProgramLabel = (programRect.getHeight() + programLabel.getAscent()) / 2;
		
		programLabel.move(centerWidthProgramLabel, centerHeightProgramLabel);
		add(programLabel);
		add(programRect);
		
		//GrapgicsProgram
		double quarterOfWidth = getWidth() / 4;
		GRect graphicRect = new GRect(quarterOfWidth - halfOfClassBoxWidth, centerHeight - halfOfClassBoxHeight, CLASS_BOX_WIDTH, CLASS_BOX_HEIGHT);
		GLabel graphicLabel = new GLabel("Graphic Program",quarterOfWidth - halfOfClassBoxWidth, centerHeight - halfOfClassBoxHeight);
		double centerWidthGraphicLabel = (graphicRect.getWidth() - graphicLabel.getWidth()) / 2;
		double centerHeightGraphicLabel = (graphicRect.getHeight() + graphicLabel.getAscent()) / 2;
		graphicLabel.move(centerWidthGraphicLabel, centerHeightGraphicLabel);
		add(graphicRect);
		add(graphicLabel);
		
		//Console	
		GRect consoleRect = new GRect((quarterOfWidth * 2) - halfOfClassBoxWidth, centerHeight - halfOfClassBoxHeight, CLASS_BOX_WIDTH, CLASS_BOX_HEIGHT);
		GLabel consoleLabel = new GLabel("Console Program",(quarterOfWidth * 2) - halfOfClassBoxWidth, centerHeight - halfOfClassBoxHeight);
		double centerWidthConsoleLabel = (consoleRect.getWidth() - consoleLabel.getWidth()) / 2;
		double centerHeightConsoleLabel = (consoleRect.getHeight() + consoleLabel.getAscent()) / 2;
		consoleLabel.move(centerWidthConsoleLabel, centerHeightConsoleLabel);
		add(consoleRect);
		add(consoleLabel);
		
		//Dialog
		GRect dialogRect = new GRect((quarterOfWidth * 3) - halfOfClassBoxWidth, centerHeight - halfOfClassBoxHeight, CLASS_BOX_WIDTH, CLASS_BOX_HEIGHT);
		
		GLabel dialogLabel = new GLabel("Dialog Program",(quarterOfWidth * 3) - halfOfClassBoxWidth, centerHeight - halfOfClassBoxHeight);
		double centerWidthDialogLabel = (dialogRect.getWidth() - dialogLabel.getWidth()) / 2;
		double centerHeightDialogLabel = (dialogRect.getHeight() + dialogLabel.getAscent()) / 2;
		dialogLabel.move(centerWidthDialogLabel, centerHeightDialogLabel);
		add(dialogRect);
		add(dialogLabel);
		
		
		
		GLine progGrapLine = new GLine(centerWidth, (centerHeight / 3) + CLASS_BOX_HEIGHT, quarterOfWidth, centerHeight - halfOfClassBoxHeight);
		add(progGrapLine);
		
		GLine progConsLine = new GLine(centerWidth, (centerHeight / 3) + CLASS_BOX_HEIGHT, (quarterOfWidth * 2), centerHeight - halfOfClassBoxHeight);
		add(progConsLine);
		
		GLine progDialLine = new GLine(centerWidth, (centerHeight / 3) + CLASS_BOX_HEIGHT, (quarterOfWidth * 3), centerHeight - halfOfClassBoxHeight);
		add(progDialLine);
	}
	
//	public double center
}

