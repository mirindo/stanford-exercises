import acm.program.*;

public class raiseIntToPower4 extends ConsoleProgram {
	public void run() {
		
		int numberToDisplay = readInt("Enter number to be powered from 0 to 10: ");
		for (int i = 0; i <= 10; i++) {
			
			println(numberToDisplay + "powered to " + i + "is: " + raiseIntToPower(numberToDisplay, i));
		}
		
	}
	
	private int raiseIntToPower(int n, int k) {
		int result = (int) Math.pow(n, k);
		return result;
	}
}
