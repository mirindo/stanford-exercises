import acm.program.*;

public class IsPerfect11 extends ConsoleProgram {
	public void run() {
//		int givenNumber = readInt("Enter number to know, if its perfect: ");
//		if (isPerfect(givenNumber)) {
//			println("Number is perfect");
//		} else {
//			println("Number is not perfect");
//		}
		for (int i = 1; i <= 9999; i++) {
			if (isPerfect(i)) println(i);
		}
	}
	
	private boolean isPerfect(int n) {
		boolean result = true;
		int perfectNumberSum = 0;
		int number = 1;
		
		while (result) {
			if (n % number == 0) perfectNumberSum += number;
			number++;
			if (perfectNumberSum == n) break;
			if (number == n) {
				result = false; 
				break;
			}
		}
		return result;
	}
}
