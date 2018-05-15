import acm.program.*;
import acm.util.*;

public class cards1 extends ConsoleProgram {
	public void run() {
		println("This program displays a randomly chosen card.");
		println(randomRank() + " of " + randomSuit());
		
	}
	
	private String randomRank() {
		String rank = "";
		//Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King
		int rankCard = rgen.nextInt(1, 14);
		switch (rankCard) {
			case 1: 
				rank = "Ace";
				break;
			case 2: 
				rank = "1";
				break;
			case 3: 
				rank = "2";
				break;
			case 4: 
				rank = "3";
				break;
			case 5: 
				rank = "4";
				break;
			case 6: 
				rank = "5";
				break;
			case 7: 
				rank = "6";
				break;
			case 8: 
				rank = "7";
				break;
			case 9: 
				rank = "8";
				break;
			case 10: 
				rank = "9";
				break;
			case 11: 
				rank = "10";
				break;
			case 12: 
				rank = "Jack";
				break;
			case 13: 
				rank = "Queen";
				break;
			case 14: 
				rank = "King";
				break;
			default:
				break;
		}
		return rank;
	}
	
	private String randomSuit() {
		String suit = "";
		//Clubs, Diamonds, Hearts, Spades
		int suitColor = rgen.nextInt(1, 4);
		switch (suitColor) {
			case 1:
				suit = "Clubs";
				break;
			case 2:
				suit = "Diamonds";
				break;
			case 3:
				suit = "Hearts";
				break;
			case 4:
				suit = "Spades";
				break;
			default:
				break;
		}
		return suit;
	}
	
	private RandomGenerator rgen = new RandomGenerator();
}
