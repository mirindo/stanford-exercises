import acm.graphics.*;
import acm.program.*;

public class Heart2 extends GraphicsProgram {
	private static final double LINE_LENGTH = 100.00;
	public void run() {
		double centerWidth = getWidth() / 2;
		double centerHeight = getHeight() / 2;
		double side = Math.sqrt(LINE_LENGTH * LINE_LENGTH + LINE_LENGTH * LINE_LENGTH);
		
		
		GLine leftLine = new GLine(centerWidth, centerHeight + LINE_LENGTH + 18, centerWidth - LINE_LENGTH, centerHeight + 18);
		add(leftLine);
		GLine rightLine = new GLine(centerWidth, centerHeight + LINE_LENGTH + 18, centerWidth + LINE_LENGTH + 4, centerHeight + 18);
		add(rightLine);
		
		GArc rightHalf = new GArc(side, side, -45, 180 );
//		GArc rightHalf = new GArc(LINE_LENGTH + 18, LINE_LENGTH + 18, -45, 180 );
		add(rightHalf, centerWidth - 18, centerHeight - LINE_LENGTH);
		
		GArc leftHalf = new GArc(side, side, 45, 180 );
//		GArc leftHalf = new GArc(LINE_LENGTH + 18, LINE_LENGTH + 18, 45, 180 );
		add(leftHalf, centerWidth - LINE_LENGTH - 18, centerHeight - LINE_LENGTH);
	}
	
	
}
