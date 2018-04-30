import acm.program.*;

public class RaiseRealToPower5 extends ConsoleProgram {
	private static double PI = 3.14;
	public void run() {
		for (int i = -4; i <= 4; i++) {
			raiseRealToPower(PI, i);
			
		}
		
	}
	
	private double raiseRealToPower(double x, int k) {
		
		double result = 0;
		if (k > 0) {
			result = Math.pow(x, k);
		} else {
			result = 1 / (Math.pow(x, k));
		}
		
		println(result);
		return result;
	}
}
