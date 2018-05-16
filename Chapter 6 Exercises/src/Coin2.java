import acm.program.*;
import acm.util.*;

public class Coin2 extends ConsoleProgram {
	public void run() {
		while (headsCount < 3) {
			println(flipCoin());
		}
		println("It took " + tossCount + " flips to get 3 consecutive heads.");
	}
	private String flipCoin() {
		String coin = "";
		boolean toss = rgen.nextBoolean();
		if (toss) {
			coin = "Heads";
			headsCount++;
			tossCount++;
		} else {
			coin = "Tails";
			headsCount = 0;
			tossCount++;
		}
		
		return coin;
	}
	private RandomGenerator rgen = new RandomGenerator();
	private int headsCount;
	private int tossCount;
}
