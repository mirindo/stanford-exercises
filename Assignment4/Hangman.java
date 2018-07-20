/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;
import java.util.ArrayList;

public class Hangman extends ConsoleProgram {

	 public void init() {
		 setSize(1000, 1000);
         canvas = new HangmanCanvas();
         add(canvas);
	}
	 
    public void run() {
		/* You fill this in */
    	
    	/* Set up the game */
    	resolution = lexicon.getWord(rgen.nextInt(0, lexicon.getWordCount() - 1));
    	for (int i = 0; i < resolution.length(); i++) word += "-";
    	guessCount = 8;
 
    	canvas.reset();
    	
    	canvas.displayWord(word);
    	
    	
    	/* Start game */
    	
    	newGame();
	}
    
    private void newGame() {
    	println("Welcome to Hangman");
    	
    	while (true) {
    		println("The word now looks like this: " + word);
    		
    		if (guessCount > 1) {
    			println("You have " + guessCount + " guesses left");
    		} else {
    			println("You have only one guess left.");
    		}        	
    		
    		/* Only for testing the program */
        	println(resolution);
        	
        	guess = readLine("Your guess: ");
        	ch = guess.charAt(0);
        	isNotValidCharacter();
        	guessCount--;
        	
        	
        	/* check for lower case characters */
        	if (Character.isLowerCase(ch)) ch = Character.toUpperCase(ch);
        	
        	/* If user guess correct character more than one */
        	if (word.indexOf(ch) > -1) {
        		println("You already guessed that character.");
        		println("Try another one.");
        		guessCount++;
        	} else {
        		
	        	/* Check if character is in the resolution */
	        	if (resolution.indexOf(ch) > -1) {
	        		guessCount++;
	        		println("That guess is correct.");	
	        		int index1 = resolution.indexOf(ch);
	        		String tempString1 = word.substring(0, index1);
	        		String tempString2 = word.substring(index1 + 1);
	        		word = tempString1 + ch + tempString2;
	        		canvas.displayWord(word);
	        		/* Check for more same character */
	        		int a = 1;
	        		while (resolution.indexOf(ch, index1 + a) > -1) {
	        			int index2 = resolution.indexOf(ch, index1 + a);
	        			tempString1 = word.substring(0, index2);
	        			tempString2 = word.substring(index2 + 1);
	        			word = tempString1 + ch + tempString2;
	        			a++;
//	        			canvas.remove(word);
	        			canvas.displayWord(word);
	        			if (a > resolution.length()) break;
	        		}
	        	} else {
	        		println("The are no " + ch + "'s in the word.");
	        		canvas.noteIncorrectGuess(ch);
	        	}
        	}
        	
        	/* if player guess the word */
        	if (word.equals(resolution)) {
        		println("You guessed the word: " + resolution);
        		println("You win.");
        		break;
        	}
        
        	/* if player run out of guesses */
        	if (guessCount <= 0) {
        		println("You're completely hung.");
        		println("The word was: " + resolution);
        		println("You lose.");
        		break;
        	}
        	
    	}
    	
    }
    
    /* check if the character player gives is not multiple characters or a number or empty*/
    private void isNotValidCharacter() {
    	while ((guess.length() != 1) || (Character.isDigit(ch))){
    		println("You entered invalid character.");
    		guess = readLine("Please, enter single character: ");
    		ch = guess.charAt(0);
    	}
    	while (ch == ' ') {
    		println("You entered empty character.");
    		guess = readLine("Please, enter single character: ");
    		ch = guess.charAt(0);
    	}
//    	while (guess.isEmpty()) {
//    		println("You entered empty character.");
//    		guess = readLine("Please, enter single character: ");
//    		ch = guess.charAt(0);
//    	}
    }
    
    private HangmanCanvas canvas;
    
    private String resolution;
    private int guessCount;
    private String word = "";
    private String guess;
    private char ch;
    private HangmanLexicon lexicon = new HangmanLexicon();
    private RandomGenerator rgen = new RandomGenerator();
}
