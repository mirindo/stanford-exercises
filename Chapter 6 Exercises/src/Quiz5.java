import acm.program.*;
import acm.util.*;

public class Quiz5 extends ConsoleProgram {
	private int ASK_TIMES_QUESTION = 5;
	public void run() {
		println("Welcome to Math Quiz");
		
		for (int j = 0; j < ASK_TIMES_QUESTION; j++) {
			int firstNumber = randomFirstNumber();
			int secondNumber = randomSecondNumber();
			int answerPlus = Math.max(firstNumber, secondNumber) + Math.min(firstNumber, secondNumber);
			int answerMinus = Math.max(firstNumber, secondNumber) - Math.min(firstNumber, secondNumber);
			int wrongAnswerPlus = 0;
			int wrongAnswerMinus = 0;
			
			String correctAnswer = randomMessage(); //6
			if(randomReaction()) {
				while (answerPlus >= 20) {
					firstNumber = randomFirstNumber();
					secondNumber = randomSecondNumber();
					answerPlus = Math.max(firstNumber, secondNumber) + Math.min(firstNumber, secondNumber);
				}
				int guessPlus = readInt("What is " + Math.max(firstNumber, secondNumber) + " + " + Math.min(firstNumber, secondNumber) + "?");
				for (int i = 0; i < 2; i++) {
					if (guessPlus == answerPlus) {
						println(correctAnswer);
						break;
					} else {
						guessPlus = readInt("That's incorrect - try a different answer: ");
						wrongAnswerPlus++;
						if (guessPlus == answerPlus) {
							println(correctAnswer);
							break;
						}
					}
				}
				if (wrongAnswerPlus == 2) {
					println("No, the answer is " + answerPlus);
				}
			} else {
				while (answerMinus <= 0) {
					firstNumber = randomFirstNumber();
					secondNumber = randomSecondNumber();
					answerMinus = Math.max(firstNumber, secondNumber) - Math.min(firstNumber, secondNumber);
				}
				int guessMinus = readInt("What is " + Math.max(firstNumber, secondNumber) + " - " + Math.min(firstNumber, secondNumber) + "?");
				for (int i = 0; i < 2; i++) {
					if (guessMinus == answerMinus) {
						println(correctAnswer);
						break;
					} else {
						guessMinus = readInt("That's incorrect - try a different answer: ");
						wrongAnswerMinus++;
						if (guessMinus == answerPlus) {
							println(correctAnswer);
							break;
						}
					}
				}
				if (wrongAnswerMinus == 2) {
					println("No, the answer is " + answerMinus);
				}
			}
		}
	}
	
	private int randomFirstNumber() {
		int firstNumber = 0;
		firstNumber = rgen.nextInt(0, 20);
		return firstNumber;
	}
	
	private int randomSecondNumber() {
		int secondNumber = 0;
		secondNumber = rgen.nextInt(0, 20);
		return secondNumber;
	}
	
	private boolean randomReaction() {
		boolean reaction = rgen.nextBoolean();
		return reaction;
	}
	
	//6
	private String randomMessage() {
		String message = "";
		int n = rgen.nextInt(0, 2);
		switch (n) {
			case 0:
				message = "You got it!";
				break;
			case 1:
				message = "Correct!";
				break;
			case 2:
				message = "That's the answer!";
				break;
			
			default:
				message = "Yes!";
				break;			
		}
		return message;
	}
	
	private RandomGenerator rgen = new RandomGenerator();
}
