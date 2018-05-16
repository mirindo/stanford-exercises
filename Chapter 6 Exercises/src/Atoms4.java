import acm.program.*;
import acm.util.*;

public class Atoms4 extends ConsoleProgram {
	public void run() {
		totalAtoms = 10000;
		totalAtomsAfter = 10000;
		println("There are " + totalAtoms + " atoms initialy");
		for (int i = 1; i <= 13; i++) {
			for (int j = 0; j < totalAtomsAfter; j++) {
				if (atomDecay()) {
					totalAtoms--;
				}
			}
			totalAtomsAfter = totalAtoms;
			println("There are " + totalAtoms + " atoms at the end of year " + i );
		}
	}
	private boolean atomDecay() {
		boolean atomDecay = (rgen.nextBoolean()) ? true : false;
		return atomDecay;
	}
	private int totalAtomsAfter;
	private int totalAtoms;
	private RandomGenerator rgen = new RandomGenerator();
}
