import acm.graphics.*;
import acm.program.*;

public class Combinations9 extends GraphicsProgram {
	private static int MAX_COMB = 8;
	
	public void run() {
		int maxRow = 0;
		int numberComb = 1;
		
		for (int j = 0; j <= MAX_COMB; j++) {
			
			for (int i = 0; i <= maxRow; i++) {
				GLabel label = combination(j, i);
				double x = ((getWidth() - (label.getWidth() * numberComb)) / 2);
				add(label, x + i*40, 20+ j*40);
			}
			maxRow++; 
			numberComb++;
		}
		
	}

	private GLabel combination(int a, int b) {	
		GLabel combinationLabel = new GLabel("C(" + a + "," + b + ")");
		return combinationLabel;
	}
}
