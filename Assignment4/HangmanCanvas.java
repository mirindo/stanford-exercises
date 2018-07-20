/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		removeAll();
		scaffold = new GLine(
				getWidth() / 4, 
				getHeight() / 2,  
				getWidth() / 4, 
				(getHeight() / 2) - SCAFFOLD_HEIGHT
				);
    	add(scaffold);
    	
    	scaffoldArm = new GLine(
    			getWidth() / 4, 
    			(getHeight() / 2) - SCAFFOLD_HEIGHT,
    			getWidth() / 4 + BEAM_LENGTH, 
    			(getHeight() / 2) - SCAFFOLD_HEIGHT
    			);
    	add(scaffoldArm);
    	
    	rope = new GLine(
    			getWidth() / 4 + BEAM_LENGTH, 
    			(getHeight() / 2) - SCAFFOLD_HEIGHT,
    			getWidth() / 4 + BEAM_LENGTH, 
    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH
    			);
    	add(rope);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
		wordOnCanvas = new GLabel(word, 125, 650);
		wordOnCanvas.setFont("Courier-24");
		add(wordOnCanvas);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		countOfIncorrect++;
		switch (countOfIncorrect) {
			case 1: 
				head = new GOval(
						getWidth() / 4 + BEAM_LENGTH - HEAD_RADIUS, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH,
		    			HEAD_RADIUS * 2, 
		    			HEAD_RADIUS * 2
						);
				add(head);
				break;
			case 2:
				body = new GLine(	
						getWidth() / 4 + BEAM_LENGTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2,
		    			getWidth() / 4 + BEAM_LENGTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH
						);				
				add(body);
				break;
			case 3:
				leftArm1 = new GLine(	
						getWidth() / 4 + BEAM_LENGTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD,
		    			getWidth() / 4 + BEAM_LENGTH - UPPER_ARM_LENGTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD
						);							
				add(leftArm1);
				leftArm2 = new GLine(
		    			getWidth() / 4 + BEAM_LENGTH - UPPER_ARM_LENGTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD,
		    			getWidth() / 4 + BEAM_LENGTH - UPPER_ARM_LENGTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH
						);							
				add(leftArm2);
				break;
			case 4:
				rightArm1 = new GLine(	
						getWidth() / 4 + BEAM_LENGTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD,
		    			getWidth() / 4 + BEAM_LENGTH + UPPER_ARM_LENGTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD
						);							
				add(rightArm1);
				rightArm2 = new GLine(
		    			getWidth() / 4 + BEAM_LENGTH + UPPER_ARM_LENGTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD,
		    			getWidth() / 4 + BEAM_LENGTH + UPPER_ARM_LENGTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH
						);							
				add(rightArm2);
				break;
			case 5:
				leftLeg1 = new GLine(	
		    			getWidth() / 4 + BEAM_LENGTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH,
		    			getWidth() / 4 + BEAM_LENGTH - HIP_WIDTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH
						);				
				add(leftLeg1);
				leftLeg2 = new GLine(
		    			getWidth() / 4 + BEAM_LENGTH - HIP_WIDTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH,
		    			getWidth() / 4 + BEAM_LENGTH - HIP_WIDTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH + LEG_LENGTH	
						);				
				add(leftLeg2);
				break;
			case 6:
				rightLeg1 = new GLine(	
		    			getWidth() / 4 + BEAM_LENGTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH,
		    			getWidth() / 4 + BEAM_LENGTH + HIP_WIDTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH
						);				
				add(rightLeg1);
				rightLeg2 = new GLine(
		    			getWidth() / 4 + BEAM_LENGTH + HIP_WIDTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH,
		    			getWidth() / 4 + BEAM_LENGTH + HIP_WIDTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH + LEG_LENGTH	
						);				
				add(rightLeg2);
				break;
			case 7:
				leftFoot = new GLine(
		    			getWidth() / 4 + BEAM_LENGTH - HIP_WIDTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH + LEG_LENGTH,
		    			getWidth() / 4 + BEAM_LENGTH - HIP_WIDTH - FOOT_LENGTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH + LEG_LENGTH	    			
						);				
				add(leftFoot);
				break;
			case 8:
				rightFoot = new GLine(
						getWidth() / 4 + BEAM_LENGTH + HIP_WIDTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH + LEG_LENGTH,
		    			getWidth() / 4 + BEAM_LENGTH + HIP_WIDTH + FOOT_LENGTH, 
		    			(getHeight() / 2) - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH + LEG_LENGTH	    			
						);				
				add(rightFoot);
				break;
			default:
				break;
		}

		incorrect += letter;
		incorrectLetters = new GLabel(incorrect, 125, 800);
		incorrectLetters.setFont("Courier-24");
		add(incorrectLetters);
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	private GLine scaffold;
	private GLine scaffoldArm;
	private GLine rope;
	private GLabel wordOnCanvas;
	
	private GOval head;
	private GLine body, leftArm1, rightArm1, leftArm2, rightArm2,
				  leftLeg1, leftLeg2, rightLeg1, rightLeg2, 
				  leftFoot, rightFoot;
	
	private int countOfIncorrect = 0;
	private String incorrect = "";
	private GLabel incorrectLetters;
}
