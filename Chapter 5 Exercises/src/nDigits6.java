import acm.program.*;

public class nDigits6 extends ConsoleProgram {
	public void run() { 
		nDigits(2145558);
		
	}
	
	private int nDigits(int n) {
		int dsum = 0;
		int numberOfDigits = 0;
		while (n > 0) {
			n /= 10;
			numberOfDigits++;
		}
		println(numberOfDigits);
		return numberOfDigits;
	}
}
