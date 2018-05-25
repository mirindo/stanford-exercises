/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		/* You fill this in */
		int counter = 0;
		int num = readInt("Enter a positive number: ");
		while (num < 1) {
			println("Please, enter positive number.");
			num = readInt("Enter a positive number: ");
		}
		while (num > 1) {
			while (num != 1) {
				if (num % 2 == 0) {
					println(num + " is even, so I take half: " + num / 2);
					num /= 2;
					counter++;
				} else {
					println(num + " is odd, so I make 3n + 1: " + ((num*3)+1));
					num *= 3;
					num += 1;
					counter++;
				}
			}
		}
		println("The process took " + counter + " steps to reach 1");
	}
}

