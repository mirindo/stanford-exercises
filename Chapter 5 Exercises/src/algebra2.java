import acm.program.*;

public class algebra2 extends ConsoleProgram {
	public void run() {
		println("Enter coefficients for the quadratic equation:");
		int a = readInt("a: ");
		int b = readInt("b: ");
		int c = readInt("c: ");
		println("The first solution is " + quadraticFirstResult(a, b, c));
		println("The second solution is " + quadraticSecondResult(a, b, c));
		
	}
	
	private int quadraticFirstResult(int x, int y, int z) {
		
		return (int) ((-(y) + Math.sqrt(Math.pow(y, 2) - 4 * x * z)) / 2 * x);
	}
	
	private int quadraticSecondResult(int x, int y, int z) {
		
		return (int) ((-(y) - Math.sqrt(Math.pow(y, 2) - 4 * x * z)) / 2 * x);
	}
}

