import acm.program.*;

public class fibonacci3 extends ConsoleProgram {

	
	public void run() {

		int fiboNum = readInt("Enter desired fibonacci number: ");
		fibonacci(fiboNum);
		
		
		
	}
	private int fibonacci(int n) {
		int firstTempNum = 0;
		int secTempNum = 1;
		int result = 0;

		for (int i = 0; i <= (n - 2); i++) {
			result = firstTempNum + secTempNum;		
			firstTempNum = secTempNum;
			secTempNum = result;	
		}
		println("Fibonacci of " + n + " is: " + result);
		return result;
	}
}
