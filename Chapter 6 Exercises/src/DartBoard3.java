import acm.program.*;
import acm.util.*;

public class DartBoard3 extends ConsoleProgram {
	public void run() {
		double insideCircle = 0;
		double outsideCircle = 0;
		
		for (int i = 0; i < 10000; i++) {
			throwDartX();
			throwDartY();
			if ((x*x + y*y) < 1.0) {
				insideCircle++;
			} else {
				outsideCircle++;
			}
		}
		
		println("Dart thrown inside: " + insideCircle);
		println("Dart thrown outside: " + outsideCircle);
		double fractionInside = insideCircle / 10000;
		double fractionOutside = outsideCircle / 10000;
		double piCalculation = fractionInside * 4;
		println("inside: " + fractionInside);
		println("outside: " + fractionOutside);
		println("My Pi calculation is:" + piCalculation);
	}
	
	
	//double r = rgen.nextDouble(-1.0, +1.0);
	
	private double throwDartX() {
		x = rgen.nextDouble(-1.0, +1.0);
		return x;
	}
	private double throwDartY() {
		y = rgen.nextDouble(-1.0, +1.0);
		return y;
		
	}
	
	private double x;
	private double y;
	private RandomGenerator rgen = new RandomGenerator();
}
