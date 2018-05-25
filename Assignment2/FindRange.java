/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	
	private static final int SENTINEL = 0;
	
	
	public void run() {
		/* You fill this in */
		int tempNum = 0;
		int tempHigh = 0;
		int tempLow = 0;
		int counter = 0;
		println("This program finds the larges and smallest numbers.");	
		while (true) {
			
			tempNum = readInt("? " );
			
			counter++;

			if (tempNum > tempHigh) {
				tempHigh = tempNum;
			}
			if (tempNum < tempLow) {
				tempLow = tempNum;
			} 
			if (counter == 2) {
				if (tempLow < 0) {
					tempHigh = tempLow;
				} else if (tempLow < tempHigh) {
					tempLow = tempHigh; 
				}
				
			}
			if (tempNum == SENTINEL && counter == 1)  {
				println("You set your first number as sentinel.");
				break;
			} else if (tempNum == SENTINEL) {
				println("smallest: " + tempLow);
				println("largest: " + tempHigh);
				break;
			}
			
			
		}
		
		
	}
	
}

