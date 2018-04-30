import acm.program.*;

public class numberOfBottles99 extends ConsoleProgram {
	/* constant for ex 1 */
	private static final int TIMES_TO_SING = 99;
	
	/* Specifies the value of the sentinel in ex 6 */
	private static final int SENTINEL = -1;

	/* Specifies the value from which to start counting down ex 8 */
	private static final int START = 10;
	
	/* Number to count fibonacci */
	private static final int FIBO = 15;
	
	
	public void run() {
//		1
//		for (int i = TIMES_TO_SING; i > 0; i--) {
//			println(i + "bottles of beer on the wall.");
//			println(i + "bottles of beer");
//			println("You take one down, pass it around.");
//		}
//		println("And then none is available! Haha!!");
		
//		2
//		for (int i = 1; i <= 10; i++) {
//			String rhymeWord;
//			
//			switch (i) {
//			case 1: 
//				rhymeWord = "thumb";
//				break;
//			case 2: 
//				rhymeWord = "shoe";
//				break;
//			case 3: 
//				rhymeWord = "knee";
//				break;
//			case 4: 
//				rhymeWord = "door";
//				break;
//			case 5: 
//				rhymeWord = "hive";
//				break;
//			case 6: 
//				rhymeWord = "sticks";
//				break;
//			case 7: 
//				rhymeWord = "up to heaven";
//				break;
//			case 8: 
//				rhymeWord = "pate";
//				break;
//			case 9: 
//				rhymeWord = "spine";
//				break;
//			case 10: 
//				rhymeWord = "shin";
//				break;
//			default: 
//				rhymeWord = "another rhyme word";
//				break;
//			}
//			
//			println("This old man, he played " + i + ".\n" + 
//					"He played knick-knack on my " + rhymeWord + ". \n"
//					+ "With a knick-knack, paddy-whack, \n"
//					+ "Give your dog a bone.\n" + 
//					"This old man came rolling home.\n");
		
//		3
//		int tempSum = 1;
//		int sum = 1;
//		int positiveInteger = readInt("Give me positive intger to calculate sum of the odd integers to that number");
//		for (int i = 1; i < positiveInteger; i++) {
//			tempSum+=2;
//			sum+=tempSum;
//			
//		}
//		println(sum);
//		
		
		
		
		
//		4
//		for (int i = 1; i <= 100; i++) {
//			if ((i % 6 == 0) || (i % 7 == 0)) {
//				println(i);
//			}
//		}
		
//		5
//		for (int i = 1; i <= 100; i++) {
//			if ((i % 6 == 0) && (i % 7 == 0)) {
//				println("These numbers are divisible by 6 and 7: " + i);
//			} else if ((i % 6 == 0) || (i % 7 == 0)) {
//				println(i);
//			}
//		}
		
//		6

		/* Runs the program */
		   
//		println("This program adds a list of integers. And then average them.");
//		println("Enter values, one per line, using " + SENTINEL);
//		println("to signal the end of the list.");
//		int total = 0;
//		int totalAverage = 0;
//		int timesAdded = 0;
//		while (true) {
//			int value = readInt(" ? ");
//			if (value == SENTINEL) break;
//				total += value;
//				timesAdded++;
//			}
//			totalAverage = total;
//			totalAverage /= timesAdded;
//		println("The total is " + totalAverage + ".");
	

		
		
//		7
//		println("This program reverses the digits in an integer.");
//	    int n = readInt("Enter a positive integer: ");
//	    int dsum = 0;
//	    while (n > 0) {
//	    	dsum += n % 10;
//	    	dsum *= 10;
//	    	n /= 10;	
//	    }
//	    dsum /= 10;
//	    println("The reversed number is " + dsum);
//
//		
//		8
//		int t = START;
//		while (t > 0) {
//			println(t);
//			t--;
//		}
//		println("Liftoff!");
		
		
//		9
//		int firstTempNum = 0;
//		int secTempNum = 1;
//		int result = 0;
//		println("F0: " + firstTempNum);
//		println("F1: " + secTempNum);
//
//		for (int i = 0; i <= (FIBO - 2); i++) {
//			result = firstTempNum + secTempNum;		
//			firstTempNum = secTempNum;
//			secTempNum = result;
//			println("F" + (i + 2) + ": " + result);		
//		}
		
		
//		10
//		int firstTempNum = 0;
//		int secTempNum = 1;
//		int result = 0;
//		int x = 0;
//		println("F0: " + firstTempNum);
//		println("F1: " + secTempNum);
//
//		while (result < 10000) {
//			result = firstTempNum + secTempNum;		
//			firstTempNum = secTempNum;
//			secTempNum = result;
//			if (result < 10000) {
//				println("F" + (x + 2) + ": " + result);		
//			}
//			x++;
//			
//		}
		
//		11
		
		
		
		
//		12
		
	
	}
}

