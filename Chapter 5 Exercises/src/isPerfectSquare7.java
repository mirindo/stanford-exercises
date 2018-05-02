import acm.program.*;

public class isPerfectSquare7 extends ConsoleProgram {
	public void run() {
		isPerfectSquare(25);
		
	}
	
	private boolean isPerfectSquare(int n) {
		int tempNumber = (int) Math.sqrt(n);
		if (tempNumber * tempNumber == n) {
			println(n + " is perfect square");
			return true;
		} else {
			println(n + " is not perfect square");
			return false;
		}
		
		
	}
}
