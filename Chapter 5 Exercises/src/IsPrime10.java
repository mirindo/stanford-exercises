import acm.program.*;

public class IsPrime10 extends ConsoleProgram {
	public void run() {
		int givenNumber = readInt("Enter number to know, if its prime: ");
		if (isPrime(givenNumber)) {
			println("Number is prime");
		} else {
			println("Number is not prime");
		}
	}
	
	private boolean isPrime(int n) {
		boolean result = true;
		if (n > 0) {
			int i = 2;
			while (result) {
				println(i);
				result = !(n % i == 0);
				println(result);
				i++;
				if (i == n) break;
			}
		}	
		return result;
	}
}
