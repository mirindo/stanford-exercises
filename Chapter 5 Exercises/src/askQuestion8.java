import acm.program.*;

public class askQuestion8 extends ConsoleProgram {
	public void run() {
		askYesNoQuestion("Would you like instructions? ");
	}

	private boolean askYesNoQuestion(String str) {
		boolean result = false;
		String userInput = readLine(str);
		
		while (!userInput.equals("yes") || !userInput.equals("no")) {
			if (userInput.equals("yes")) {
				result = true;
				break;
			} else if (userInput.equals("no")) {
				result = false;
				break;
			} else {
				println("Please answer yes or no");
				
				userInput = readLine(str);
			}
			
			
		}
		return result;
		
	}
}
